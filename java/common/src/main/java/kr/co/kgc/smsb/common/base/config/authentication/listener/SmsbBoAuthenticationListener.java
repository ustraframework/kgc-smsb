package kr.co.kgc.smsb.common.base.config.authentication.listener;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.gsitm.ustra.java.core.process.ProcessInfoUtils;
import com.gsitm.ustra.java.core.properties.UstraProperties;
import com.gsitm.ustra.java.data.utils.UstraTransactionUtils;
import com.gsitm.ustra.java.data.utils.UstraTransactionUtils.TransactionExecuteOption;
import com.gsitm.ustra.java.management.models.UstraLoginHistoryModel;
import com.gsitm.ustra.java.management.services.UstraLoginHistoryService;
import com.gsitm.ustra.java.mvc.process.ProcessInfoWebUtils;
import com.gsitm.ustra.java.mvc.utils.UstraWebUtils;
import com.gsitm.ustra.java.security.authentication.authentication.UstraAuthentication;
import com.gsitm.ustra.java.security.authentication.listener.UstraAuthenticationListener;
import com.gsitm.ustra.java.security.authentication.processor.UstraAuthenticationProcessor;
import com.gsitm.ustra.java.security.authentication.request.token.UstraAuthenticationRequestToken;
import com.gsitm.ustra.java.security.exception.UstraSecurityAuthenticationException;
import com.gsitm.ustra.java.security.exception.UstraSecurityException;
import com.gsitm.ustra.java.security.exception.UstraSecurityResponseCode;
import com.gsitm.ustra.java.security.jwt.authentication.authentication.UstraJwtAuthentication;

import kr.co.kgc.smsb.common.base.config.authentication.user.SmsbBoUser;
import lombok.extern.slf4j.Slf4j;

/**
 * TODO : �� Ŭ������ �ʿ����� ���� �ʿ�
 *
 */
@Slf4j
public class SmsbBoAuthenticationListener implements UstraAuthenticationListener<UstraAuthenticationRequestToken, UstraJwtAuthentication> {
	@Autowired private UstraLoginHistoryService historyService;
	@Autowired private UstraProperties properties;

	// ����Ͻ� ���� ���� ����
	// @Autowired private AuthenticationService authenticationService;

	@Override
	public void onAuthenticateSuccess(UstraAuthenticationProcessor<UstraAuthenticationRequestToken, UstraJwtAuthentication> processor, UstraAuthenticationRequestToken authenticationToken, UstraJwtAuthentication authentication, String resCode) {

		if (!authentication.isAuthenticationCompleted()) {
			return;
		}

		SmsbBoUser user = (SmsbBoUser)authentication.getUser();
		UstraLoginHistoryModel historyModel = new UstraLoginHistoryModel();
		historyModel.setUsrId(authenticationToken.getUserName());
		historyModel.setSysCd(this.getAuthenticationSystemCode(authentication, processor));
		historyModel.setResCdVal(resCode);
		historyModel.setProcId(ProcessInfoUtils.getCurrentProcessId());
		historyModel.setReqId(ProcessInfoUtils.getCurrentRequestId());
		historyModel.setDeptNm(user.getDeptNm());
		historyModel.setUsrKey(user.getUserKey());
		historyModel.setUsrNm(user.getDisplayName());
		historyModel.setAccIp(UstraWebUtils.getClientIp());

		UstraTransactionUtils.execute(info -> {
			info.setLoginHistId(historyService.getKey());
			historyService.addLoginHistory(info);
//			authenticationService.updateOnLogin(true, authenticationToken.getUserName(), false);
			return 0;
		}, historyModel, TransactionExecuteOption.withDefault());
	}

	@Override
	public void onAuthenticateFailure(
			UstraAuthenticationProcessor<UstraAuthenticationRequestToken, UstraJwtAuthentication> processor,
			UstraAuthenticationRequestToken authenticationToken, Exception e, String resCode) {
		SmsbBoUser user = this.getUserFromException(e);

		UstraLoginHistoryModel historyModel = new UstraLoginHistoryModel();
		historyModel.setUsrId(authenticationToken.getUserName());
		historyModel.setSysCd(this.getAuthenticationSystemCode(null, processor));
		historyModel.setResCdVal(resCode);
		historyModel.setProcId(ProcessInfoUtils.getCurrentProcessId());
		historyModel.setReqId(ProcessInfoUtils.getCurrentRequestId());
		historyModel.setAccIp(UstraWebUtils.getClientIp());

		if (user != null) {
			historyModel.setDeptNm(user.getDeptNm());
			historyModel.setUsrKey(user.getUserKey());
			historyModel.setUsrNm(user.getDisplayName());
		}


		UstraTransactionUtils.execute(info -> {
			info.setLoginHistId(historyService.getKey());
			historyService.addLoginHistory(info);

			// 비밀번호 불일치에만 failCount 증가 처리
//			authenticationService.updateOnLogin(false, authenticationToken.getUserName(),
//					StringUtils.equals(UstraSecurityResponseCode.NOT_MATCH_PASSWORD.getCode(), resCode));
			return 0;
		}, historyModel, TransactionExecuteOption.withDefault());
	}


	@Override
	public void onUnauthenticateSuccess(UstraAuthenticationProcessor<UstraAuthenticationRequestToken, UstraJwtAuthentication> processor, UstraJwtAuthentication authentication,
			String resCode) {

		String userKey = authentication != null ? authentication.getName() : null;
		int updatedCnt = 0;


		if (StringUtils.isNotEmpty(userKey)) {

			UstraLoginHistoryModel loginHistoryModel = new UstraLoginHistoryModel();

			loginHistoryModel.setUsrKey(userKey);
			loginHistoryModel.setUpdUsrId(userKey);
			loginHistoryModel.setAccIp(UstraWebUtils.getClientIp());

			if (StringUtils.isNotEmpty(authentication.getProcessId())) {
				loginHistoryModel.setProcId(authentication.getProcessId());
				updatedCnt = historyService.updateLoginHistory(loginHistoryModel);
			}

			if (updatedCnt < 1) {
				loginHistoryModel.setProcId(null);
				loginHistoryModel.setSysCd(this.getAuthenticationSystemCode(authentication, processor));
				historyService.updateLoginHistory(loginHistoryModel);
			}

		}

	}

	@Override
	public void onAutomaticUnauthenticated(UstraAuthenticationProcessor<UstraAuthenticationRequestToken, UstraJwtAuthentication> processor, String procId, String userName, String clientIp) {

		log.info("onAutomaticUnauthenticated");

		int updatedCnt = 0;
		if (StringUtils.isNotEmpty(userName)) {
			UstraLoginHistoryModel loginHistoryModel = new UstraLoginHistoryModel();

			loginHistoryModel.setUsrKey(userName);
			loginHistoryModel.setUpdUsrId(userName);
			loginHistoryModel.setAccIp(clientIp);

			if (StringUtils.isNotEmpty(procId)) {
				loginHistoryModel.setProcId(procId);
				updatedCnt = historyService.updateLoginHistory(loginHistoryModel);
			}

			if (updatedCnt < 1) {
				loginHistoryModel.setProcId(null);
				loginHistoryModel.setSysCd(this.getAuthenticationSystemCode(null, processor));
				historyService.updateLoginHistory(loginHistoryModel);
			}
		}
	}

	/**
	 * Exception으로부터 SmsbBoUser 조회
	 * @param e
	 * @return
	 */
	protected SmsbBoUser getUserFromException(Exception e) {

		if (e instanceof UstraSecurityAuthenticationException) {

			UstraSecurityAuthenticationException securityException = (UstraSecurityAuthenticationException)e;

			// SSO RETRY
//			if (securityException.getCode().equals(SmsbResponseCode.REQUIRE_TRY_SSO.getCode())) {
//				throw securityException;
//			}

			if (securityException.getAuthenticationFailureData().getUser() != null &&
					securityException.getAuthenticationFailureData().getUser() instanceof SmsbBoUser) {
				return (SmsbBoUser)securityException.getAuthenticationFailureData().getUser();
			}


		} else if (e instanceof UstraSecurityException) {
			UstraSecurityException securityException = (UstraSecurityException)e;

			if (securityException.getData() != null && securityException.getData() instanceof UstraAuthentication) {

				UstraAuthentication authentication = (UstraAuthentication)securityException.getData();

				if (authentication.getDetails() != null && authentication.getDetails() instanceof SmsbBoUser) {
					return (SmsbBoUser)authentication.getDetails();
				}

			}
		}
		return null;

	}

	/**
	 * 인증된 시스템 정보 추출
	 * @param authentication 인증 객체
	 * @param processor 인증 프로세서
	 * @return 시스템 코드
	 */
	protected String getAuthenticationSystemCode(UstraJwtAuthentication authentication, UstraAuthenticationProcessor<UstraAuthenticationRequestToken, UstraJwtAuthentication> processor) {

		if (authentication != null && StringUtils.isNotEmpty(authentication.getAuthSystemCode())) {
			return authentication.getAuthSystemCode();
		}

		if (ProcessInfoWebUtils.getCurrentProcessInfo() != null &&
				StringUtils.isNotEmpty(ProcessInfoWebUtils.getCurrentProcessInfo().getSystemCode())) {
			return ProcessInfoWebUtils.getCurrentProcessInfo().getSystemCode();
		}

		if (StringUtils.isNotEmpty(processor.getAuthenticationProperties().getSystemKey())) {
			return processor.getAuthenticationProperties().getSystemKey();
		}

		return properties.getCore().getProcessInfo().getDefaultSystemCode();

	}
}

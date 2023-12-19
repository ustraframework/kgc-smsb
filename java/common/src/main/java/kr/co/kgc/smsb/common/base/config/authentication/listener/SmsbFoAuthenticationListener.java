package kr.co.kgc.smsb.common.base.config.authentication.listener;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.gsitm.ustra.java.core.properties.UstraProperties;
import com.gsitm.ustra.java.mvc.process.ProcessInfoWebUtils;
import com.gsitm.ustra.java.security.authentication.authentication.UstraAuthentication;
import com.gsitm.ustra.java.security.authentication.listener.UstraAuthenticationListener;
import com.gsitm.ustra.java.security.authentication.processor.UstraAuthenticationProcessor;
import com.gsitm.ustra.java.security.authentication.request.token.UstraAuthenticationRequestToken;
import com.gsitm.ustra.java.security.exception.UstraSecurityAuthenticationException;
import com.gsitm.ustra.java.security.exception.UstraSecurityException;
import com.gsitm.ustra.java.security.jwt.authentication.authentication.UstraJwtAuthentication;

import kr.co.kgc.smsb.common.base.config.authentication.user.SmsbFoUser;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SmsbFoAuthenticationListener implements UstraAuthenticationListener<UstraAuthenticationRequestToken, UstraJwtAuthentication> {
	@Autowired private UstraProperties properties;

	@Override
	public void onAuthenticateSuccess(UstraAuthenticationProcessor<UstraAuthenticationRequestToken, UstraJwtAuthentication> processor, UstraAuthenticationRequestToken authenticationToken, UstraJwtAuthentication authentication, String resCode) {

		if (!authentication.isAuthenticationCompleted()) {
			return;
		}

		SmsbFoUser user = (SmsbFoUser)authentication.getUser();
		// TODO: FO 인증 완료후 처리할 작업

	}

	@Override
	public void onAuthenticateFailure(
			UstraAuthenticationProcessor<UstraAuthenticationRequestToken, UstraJwtAuthentication> processor,
			UstraAuthenticationRequestToken authenticationToken, Exception e, String resCode) {
		
		SmsbFoUser user = this.getUserFromException(e);
		// TODO: FO 인증 실패후 처리할 작업
	}


	@Override
	public void onUnauthenticateSuccess(UstraAuthenticationProcessor<UstraAuthenticationRequestToken, UstraJwtAuthentication> processor, UstraJwtAuthentication authentication,
			String resCode) {

		String userKey = authentication != null ? authentication.getName() : null;
		// TODO: FO 로그아웃후 처리할 작업

	}

	@Override
	public void onAutomaticUnauthenticated(UstraAuthenticationProcessor<UstraAuthenticationRequestToken, UstraJwtAuthentication> processor, String procId, String userName, String clientIp) {

		log.info("onAutomaticUnauthenticated");
		// TODO: FO 자동 로그아웃시 처리할 작업
		
	}

	/**
	 * Exception으로부터 SmsbFoUser 조회
	 * @param e
	 * @return
	 */
	protected SmsbFoUser getUserFromException(Exception e) {

		if (e instanceof UstraSecurityAuthenticationException) {

			UstraSecurityAuthenticationException securityException = (UstraSecurityAuthenticationException)e;

			if (securityException.getAuthenticationFailureData().getUser() != null &&
					securityException.getAuthenticationFailureData().getUser() instanceof SmsbFoUser) {
				return (SmsbFoUser)securityException.getAuthenticationFailureData().getUser();
			}


		} else if (e instanceof UstraSecurityException) {
			UstraSecurityException securityException = (UstraSecurityException)e;

			if (securityException.getData() != null && securityException.getData() instanceof UstraAuthentication) {

				UstraAuthentication authentication = (UstraAuthentication)securityException.getData();

				if (authentication.getDetails() != null && authentication.getDetails() instanceof SmsbFoUser) {
					return (SmsbFoUser)authentication.getDetails();
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

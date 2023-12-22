package kr.co.kgc.smsb.fo.config.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gsitm.ustra.java.security.authentication.UstraAuthenticationManager;
import com.gsitm.ustra.java.security.authentication.authentication.UstraAuthentication;
import com.gsitm.ustra.java.security.authentication.request.token.UserNamePasswordAuthenticationRequestToken;
import com.gsitm.ustra.java.security.authentication.request.token.UstraAuthenticationRequestToken;
import com.gsitm.ustra.java.security.exception.UstraSecurityAuthenticationException;
import com.gsitm.ustra.java.security.exception.UstraSecurityResponseCode;

import kr.co.kgc.smsb.common.base.config.authentication.user.SmsbFoUser;
import kr.co.kgc.smsb.common.base.exception.SmsbResponseCode;

@RestController
public class AuthenticationController {

	@Autowired private UstraAuthenticationManager authenticationManager;

	/**
	 * 로그인
	 * @param in
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/api/authentication/login")
	public LoginResultModel login(@RequestBody UserNamePasswordAuthenticationRequestToken in) throws Exception {
		return this.getLoginResult(in);
	}
	
	/**
	 * 로그아웃
	 * @param in
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/api/authentication/logout")
	public void logout() throws Exception {
		this.authenticationManager.unAuthenticate(authenticationManager.getAuthentication());
	}
	
	/**
	 * 로그인 정보 조회
	 * @param requestToken 토큰
	 * @return
	 * @throws Exception
	 */
	protected LoginResultModel getLoginResult(UstraAuthenticationRequestToken requestToken) throws Exception {

		UstraAuthentication authentication = null;

		try {
			authentication = this.authenticationManager.authenticate(requestToken);
		} catch(UstraSecurityAuthenticationException e) {

			LoginResultModel res = new LoginResultModel();

			res.setResCd(UstraSecurityResponseCode.NOT_MATCH_USER.getCode());

			if (SmsbResponseCode.APPLICATION_STATUS_USER.getCode().equals(e.getCode())) {
				res.setResCd(SmsbResponseCode.APPLICATION_STATUS_USER.getCode());
			}
			res.setLoginFailCnt(1);

			if (e.getAuthenticationFailureData().getUser() != null) {
				res.setHasUser(true);
				res.setUserKey(e.getAuthenticationFailureData().getUser().getUserKey());

				if (e.getAuthenticationFailureData().getUser() instanceof SmsbFoUser) {
					SmsbFoUser user = (SmsbFoUser)e.getAuthenticationFailureData().getUser();

					if (user.getLoginFailCnt() != null) {
						res.setLoginFailCnt(user.getLoginFailCnt() + 1);
					}

					if (!UstraSecurityResponseCode.NOT_MATCH_PASSWORD.getCode().equals(e.getCode())) {
						res.setRequiredChangePassword(user.isRequiredChangePassword());
						res.setUserName(user.getDisplayName());
					} else {
						res.setHasUser(false);
						res.setUserKey(null);
					}
				}
			}

			return res;
		}


		SmsbFoUser user = (SmsbFoUser)authentication.getUser();

		LoginResultModel res = new LoginResultModel();
		res.setAuthenticated(true);
		res.setHasUser(true);
		res.setLoginFailCnt(0);
		res.setResetPassword(user.isResetPassword());
		res.setRequiredChangePassword(user.isRequiredChangePassword());
		res.setResCd("0000");
		res.setUserKey(authentication.getName());
		res.setUserName(user.getDisplayName());
		res.setSessionId(authentication.getProcessId());


		// set when password expired
		if (!user.isCredentialsNonExpired()) {
			res.setResCd(UstraSecurityResponseCode.CREDENTIALS_EXPIRED_USER.getCode());
		}

		// set when expired
		if (!user.isAccountNonExpired()) {
			res.setResCd(UstraSecurityResponseCode.EXPIRED_USER.getCode());
		}

		return res;
	}
}

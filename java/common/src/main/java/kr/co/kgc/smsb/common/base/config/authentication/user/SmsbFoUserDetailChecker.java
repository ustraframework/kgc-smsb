package kr.co.kgc.smsb.common.base.config.authentication.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.gsitm.ustra.java.security.authentication.request.token.UserNamePasswordAuthenticationRequestToken;
import com.gsitm.ustra.java.security.authentication.request.token.UstraAuthenticationRequestToken;
import com.gsitm.ustra.java.security.authentication.user.UstraUser;
import com.gsitm.ustra.java.security.authentication.user.checker.DefaultUstraUserDetailChecker;
import com.gsitm.ustra.java.security.exception.UstraSecurityAuthenticationException;
import com.gsitm.ustra.java.security.exception.UstraSecurityResponseCode;

public class SmsbFoUserDetailChecker extends DefaultUstraUserDetailChecker<UstraAuthenticationRequestToken> {

	@Autowired private PasswordEncoder passwordEncoder;

	@Override
	public void check(UstraAuthenticationRequestToken requestToken, UstraUser userDetails) {
		if (userDetails == null) {
			throw UstraSecurityAuthenticationException.of(UstraSecurityResponseCode.NOT_MATCH_USER, requestToken, null);
		}

		UstraUser user = (UstraUser)userDetails;

		// 접속 불가 지역
		if ( !user.isConnectedRegionAllowed()) {
			throw UstraSecurityAuthenticationException.of(UstraSecurityResponseCode.NOT_ALLOWED_CONNECTION_REGION, requestToken, user);
		}

		// 비밀번호 비교
		if( requestToken != null && requestToken instanceof UserNamePasswordAuthenticationRequestToken ) {
			if( !passwordEncoder.matches(((UserNamePasswordAuthenticationRequestToken)requestToken).getPassword(), userDetails.getPassword()) ) {
				throw UstraSecurityAuthenticationException.of(UstraSecurityResponseCode.NOT_MATCH_PASSWORD, requestToken, user);
			}
		}

		// 비활성화 유저
		if ( !userDetails.isEnabled() ) {
			throw UstraSecurityAuthenticationException.of(UstraSecurityResponseCode.DISABLED_USER, requestToken, user);
		}

		// 만료 유저
//		if ( !userDetails.isAccountNonExpired() ) {
//			throw UstraSecurityAuthenticationException.of(UstraSecurityResponseCode.EXPIRED_USER, requestToken, user);
//		}

		// 잠금 상태
		if ( !userDetails.isAccountNonLocked() ) {
			throw UstraSecurityAuthenticationException.of(UstraSecurityResponseCode.ACCOUNT_LOCKED_USER, requestToken, user);
		}

		// 비밀번호 만료
		if ( !userDetails.isCredentialsNonExpired() ) {
			throw UstraSecurityAuthenticationException.of(UstraSecurityResponseCode.CREDENTIALS_EXPIRED_USER, requestToken, user);
		}

	}
}

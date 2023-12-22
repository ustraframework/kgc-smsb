package kr.co.kgc.smsb.common.base.config.authentication.claim;

import org.springframework.security.core.Authentication;

import com.gsitm.ustra.java.security.jwt.authentication.authentication.UstraJwtAuthentication;
import com.gsitm.ustra.java.security.jwt.authentication.claims.UstraJwtClaims;

import kr.co.kgc.smsb.common.base.config.authentication.user.SmsbFoUser;

/**
 * FO Claim Appender
 */
public class SmsbFoJwtClaimAppender extends SmsbJwtClaimAppender {

	@Override
	public void append(UstraJwtClaims claims, Authentication authentication) {
		super.append(claims, authentication);

		if( authentication instanceof UstraJwtAuthentication ) {
			UstraJwtAuthentication jwtAuthentication = (UstraJwtAuthentication)authentication;

			if (jwtAuthentication.getUser() instanceof SmsbFoUser) {
				SmsbFoUser ustraSystemUser = (SmsbFoUser)jwtAuthentication.getUser();

				// JWT 토큰 클레임에 추가할 정보
				claims.put("userNm", ustraSystemUser.getDisplayName());
			}
		}
	}
}
package kr.co.kgc.smsb.common.base.config.authentication.claim;

import org.springframework.security.core.Authentication;

import com.gsitm.ustra.java.security.jwt.authentication.authentication.UstraJwtAuthentication;
import com.gsitm.ustra.java.security.jwt.authentication.claims.UstraJwtClaims;

import kr.co.kgc.smsb.common.base.config.authentication.user.SmsbBoUser;

public class SmsbBoJwtClaimAppender extends SmsbJwtClaimAppender {

	@Override
	public void append(UstraJwtClaims claims, Authentication authentication) {
		super.append(claims, authentication);

		if( authentication instanceof UstraJwtAuthentication ) {
			UstraJwtAuthentication jwtAuthentication = (UstraJwtAuthentication)authentication;

			if (jwtAuthentication.getUser() instanceof SmsbBoUser) {
				SmsbBoUser ustraSystemUser = (SmsbBoUser)jwtAuthentication.getUser();

				claims.put("userNm", ustraSystemUser.getDisplayName());
				claims.put("pm", ustraSystemUser.isPrivacyInfoManager() ? "1" : "0");
				claims.put("deptNm", ustraSystemUser.getDeptNm());
				claims.put("suppcCd", ustraSystemUser.getSuppcCd());
				claims.put("suppcNm", ustraSystemUser.getSuppcNm());
				claims.put("rankNm", ustraSystemUser.getRankNm());
			}
		}
	}
}
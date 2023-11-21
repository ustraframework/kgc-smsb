package kr.co.kgc.smsb.bo.utils;

import org.springframework.lang.Nullable;

import com.gsitm.ustra.java.core.utils.ApplicationContextProvider;
import com.gsitm.ustra.java.security.authentication.UstraAuthenticationManager;
import com.gsitm.ustra.java.security.authentication.authentication.UstraAuthentication;

import kr.co.kgc.smsb.common.base.config.authentication.user.SmsbBoUser;
import lombok.experimental.UtilityClass;

@UtilityClass
public class SmsbBoAuthenticationUtils {

	/**
	 * 현재 로그인 된 BO 사용자 정보를 조회
	 * @return
	 */
	@Nullable
	public SmsbBoUser getCurrentUser() {
		UstraAuthenticationManager authenticationManager = ApplicationContextProvider.getBean(UstraAuthenticationManager.class);
		UstraAuthentication authentication = authenticationManager.getAuthentication();

		if (authentication == null || authentication.getUser() == null || authentication.isAnonymous() ||
				!(authentication.getUser() instanceof SmsbBoUser)) {
			return null;
		}

		return (SmsbBoUser)authentication.getUser();
	}
}

package kr.co.kgc.smsb.legacy.utils;

import org.springframework.lang.Nullable;

import com.gsitm.ustra.java.core.utils.ApplicationContextProvider;
import com.gsitm.ustra.java.security.authentication.UstraAuthenticationManager;
import com.gsitm.ustra.java.security.authentication.authentication.UstraAuthentication;

import kr.co.kgc.smsb.common.base.config.authentication.user.SmsbFoUser;
import lombok.experimental.UtilityClass;

@UtilityClass
public class SmsbLegacyAuthenticationUtils {

	@Nullable
	public SmsbFoUser getCurrentUser() {
		UstraAuthenticationManager authenticationManager = ApplicationContextProvider.getBean(UstraAuthenticationManager.class);
		UstraAuthentication authentication = authenticationManager.getAuthentication();

		if (authentication == null || authentication.getUser() == null || authentication.isAnonymous() ||
				!(authentication.getUser() instanceof SmsbFoUser)) {
			return null;
		}

		return (SmsbFoUser)authentication.getUser();
	}
}

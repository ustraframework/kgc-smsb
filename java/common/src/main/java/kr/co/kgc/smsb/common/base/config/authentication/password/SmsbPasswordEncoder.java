package kr.co.kgc.smsb.common.base.config.authentication.password;

import org.apache.commons.codec.binary.StringUtils;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.gsitm.ustra.java.core.utils.UstraEncShaUtils;

public class SmsbPasswordEncoder  implements PasswordEncoder {

	@Override
	public String encode(CharSequence rawPassword) {
		return UstraEncShaUtils.encodeSha256WithoutSaltkey(rawPassword.toString());
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		return StringUtils.equals(UstraEncShaUtils.encodeSha256WithoutSaltkey(rawPassword.toString()), encodedPassword);
	}
}

package kr.co.kgc.smsb.fo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import com.gsitm.ustra.java.security.jwt.authentication.properties.UstraJwtAuthenticationProperties;

import lombok.Data;

@Data
@Component
@ConfigurationProperties( value = SmsbFoConfigProperties.PREFIX, ignoreInvalidFields = true, ignoreUnknownFields = true)
public class SmsbFoConfigProperties {
	public static final String PREFIX = "smsb.fo";

	private String sampleProp;
	
	private UstraJwtAuthenticationProperties authentication;

	private SnsInfo sns;
}

@Data
class SnsInfo {
	private String snsId;
	private String snsPw;
}
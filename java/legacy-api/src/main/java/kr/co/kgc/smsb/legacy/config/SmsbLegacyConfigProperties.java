package kr.co.kgc.smsb.legacy.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@ConfigurationProperties( value = SmsbLegacyConfigProperties.PREFIX, ignoreUnknownFields = true )
public class SmsbLegacyConfigProperties {
	public static final String PREFIX = "smsb.legacy";

	private String sampleProp;
}
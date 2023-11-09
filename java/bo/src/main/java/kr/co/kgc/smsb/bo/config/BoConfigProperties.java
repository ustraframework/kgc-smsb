package kr.co.kgc.smsb.bo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@ConfigurationProperties( value = BoConfigProperties.PREFIX, ignoreUnknownFields = true )
public class BoConfigProperties {
	public static final String PREFIX = "smsb.bo";

	private String sampleProp;
}

package kr.co.kgc.smsb.fo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@ConfigurationProperties( value = SmsbFoConfigProperties.PREFIX, ignoreUnknownFields = true )
public class SmsbFoConfigProperties {
	public static final String PREFIX = "smsb.fo";

	private String sampleProp;
}
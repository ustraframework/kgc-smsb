package kr.co.kgc.smsb.api.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@ConfigurationProperties( value = SmsbApiConfigProperties.PREFIX, ignoreUnknownFields = true )
public class SmsbApiConfigProperties {
	public static final String PREFIX = "smsb.api";

	private String sampleProp;
}
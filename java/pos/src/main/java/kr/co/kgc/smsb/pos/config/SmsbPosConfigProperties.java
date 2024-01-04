package kr.co.kgc.smsb.pos.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@ConfigurationProperties( value = SmsbPosConfigProperties.PREFIX, ignoreUnknownFields = true )
public class SmsbPosConfigProperties {
	public static final String PREFIX = "smsb.pos";

	private String sampleProp;
	private SnsInfo snsInfo;
}
@Data
class SnsInfo {
	private String url;
	private String secretKey;
}
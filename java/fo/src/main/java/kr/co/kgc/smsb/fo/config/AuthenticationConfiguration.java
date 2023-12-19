package kr.co.kgc.smsb.fo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import kr.co.kgc.smsb.common.base.config.authentication.SmsbAuthenticationProcessor;
import kr.co.kgc.smsb.common.base.config.authentication.password.SmsbFoPasswordEncoder;


@Configuration
public class AuthenticationConfiguration {

	@Bean
	SmsbAuthenticationProcessor smsbAuthenticationProcessor(SmsbFoConfigProperties properties) {
		return SmsbAuthenticationProcessor.createFoProcessor(properties.getAuthentication());
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new SmsbFoPasswordEncoder();
	}

}

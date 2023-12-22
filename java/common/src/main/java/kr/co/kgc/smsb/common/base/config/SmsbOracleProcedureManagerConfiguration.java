package kr.co.kgc.smsb.common.base.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SmsbOracleProcedureManagerConfiguration {
	@Bean
	SmsbUstraCustomOracleProcedureManager oracleProcedureManager(DataSource dataSource) {
		return new SmsbUstraCustomOracleProcedureManager(dataSource);
	} 
}

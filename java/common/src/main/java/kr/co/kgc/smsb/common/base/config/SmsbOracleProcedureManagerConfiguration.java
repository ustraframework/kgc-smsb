package kr.co.kgc.smsb.common.base.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gsitm.ustra.java.data.utils.procedure.UstraOracleProcedureManager;

@Configuration
public class SmsbOracleProcedureManagerConfiguration {
	@Bean
	UstraOracleProcedureManager oracleProcedureManager(DataSource dataSource) {
		return new UstraOracleProcedureManager(dataSource);
	} 
}

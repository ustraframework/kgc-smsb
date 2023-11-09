package kr.co.kgc.smsb.common.base.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.gsitm.ustra.java.security.config.UstraSecurityConfigure;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SmsbSwaggerConfiguration {

    @Bean
    UstraSecurityConfigure commonSwaggerSecurityConfigure() {
    	return new UstraSecurityConfigure() {
    		@Override
    		public void postConfigure(WebSecurity web) throws Exception {
    			web.ignoring().antMatchers(
    				// Swagger UI v2
    				"/v2/api-docs"
    				, "/swagger-resources/**"
    				, "/swagger-ui.html"
    				, "/webjars/**"
    				, "/swagger/**"
    			);
    		}
    	};
    }

    @Bean
    WebMvcConfigurer webMvcConfigurer() {
    	return new WebMvcConfigurer() {
    		@Override
    		public void addResourceHandlers(ResourceHandlerRegistry registry) {

    			// "/v2/common-api-docs", "/common-swagger-resources/**", "/common-swagger-ui.html", "/common-webjars/**"
    			registry.addResourceHandler("/swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
    			registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    		}
    	};
    }
}

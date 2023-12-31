package kr.co.kgc.smsb.api;

import java.io.IOException;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;

import com.gsitm.ustra.java.mvc.app.ServletApplicationRunner;

@SpringBootApplication
@ComponentScan("kr.co.kgc.smsb")
public class ApiApplication extends ServletApplicationRunner {
	public ApiApplication() {
		super(ApiApplication.class);
	}

	public static void main(String[] args) throws IOException {
		final SpringApplicationBuilder builder = new SpringApplicationBuilder(ApiApplication.class);
		addProperties(builder);
		ServletApplicationRunner.run(ApiApplication.class, builder, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		addProperties(builder);
		super.configure(builder);

		return builder;
	}

	private static void addProperties(SpringApplicationBuilder builder) {
		builder.properties("spring.config.location=classpath:/common-config.yml, classpath:/application.yml");
	}
}

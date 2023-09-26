package kr.co.kgc.smsb.bo;

import java.io.IOException;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;

import com.gsitm.ustra.java.mvc.app.ServletApplicationRunner;

@SpringBootApplication
@ComponentScan("kr.co.kgc.smsb")
public class BoApplication extends ServletApplicationRunner {
	public BoApplication() {
		super(BoApplication.class);
	}

	public static void main(String[] args) throws IOException {
		final SpringApplicationBuilder builder = new SpringApplicationBuilder(BoApplication.class);
		addProperties(builder);
		ServletApplicationRunner.run(BoApplication.class, builder, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		addProperties(builder);
		super.configure(builder);

		return builder;
	}

	private static void addProperties(SpringApplicationBuilder builder) {
		builder.properties("spring.config.location=classpath:/common-config.yml");
	}
}

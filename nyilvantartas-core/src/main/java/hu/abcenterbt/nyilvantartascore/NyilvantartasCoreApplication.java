package hu.abcenterbt.nyilvantartascore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EntityScan("hu.abcenterbt.nyilvantartasapi")
@SpringBootApplication
@EnableSwagger2
public class NyilvantartasCoreApplication extends SpringBootServletInitializer {

	public static void main(final String[] args) {
		SpringApplication.run(NyilvantartasCoreApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(final SpringApplicationBuilder builder) {
		return builder.sources(NyilvantartasCoreApplication.class);
	}


	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("hu.abcenterbt.nyilvantartascore"
				)).build();
	}
}

package co.com.gsdd.demo.mongo.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import co.com.gsdd.demo.mongo.constants.DemoConstants;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage(DemoConstants.CONTROLLER_PKG))
				.paths(PathSelectors.regex("/employee.*")).build().apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		return new ApiInfo("Employee NoSQL REST", "REST services Spring-Boot & Mongo", "0.0.1.SNAPSHOT",
				"No terms of service", new Contact("A. Galvis", "", "alex.galvis.sistemas@gmail.com"), "It's free!!",
				"It's free!!", Collections.emptyList());
	}
}

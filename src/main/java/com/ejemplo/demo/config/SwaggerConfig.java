package com.ejemplo.demo.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ejemplo.demo.constantes.ConstantesDemo;

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
				.apis(RequestHandlerSelectors.basePackage(ConstantesDemo.PAQUETE_CONTROLADOR))
				.paths(PathSelectors.regex("/empleado.*")).build().apiInfo(apiInfo());
	}
	
	private ApiInfo apiInfo() {
		return new ApiInfo("Employee NoSQL REST", "REST con Spring-Boot y Mongo", "0.0.1.SNAPSHOT",
				"No tengo terminos de servicio", new Contact("A. Galvis", "", "alexander.galvis@globant.com"),
				"It's free!!", "Ya habia dicho que es gratis :v", Collections.emptyList());
	}
}

package com.gsdd.demo.mongo;

import com.gsdd.demo.mongo.constants.DemoConstants;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@SpringBootApplication
@EnableReactiveMongoRepositories
@ComponentScan({DemoConstants.CONFIG_PKG, DemoConstants.CONTROLLER_PKG, DemoConstants.REPO_PKG,
    DemoConstants.SERVICE_PKG})
@OpenAPIDefinition(
    info =
        @Info(
            title = "Demo Mongo API",
            version = "2.0",
            description = "REST with Spring-Boot & Mongo",
            contact = @Contact(email = "alex.galvis.sistemas@gmail.com")))
public class MongoApplication {

  public static void main(String[] args) {
    SpringApplication.run(MongoApplication.class, args);
  }
}

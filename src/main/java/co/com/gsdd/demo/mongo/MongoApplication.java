package co.com.gsdd.demo.mongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

import co.com.gsdd.demo.mongo.constants.DemoConstants;

@SpringBootApplication
@EnableReactiveMongoRepositories
@ComponentScan({ DemoConstants.CONFIG_PKG, DemoConstants.CONTROLLER_PKG, DemoConstants.SERVICE_PKG })
public class MongoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongoApplication.class, args);
	}
}

package com.ejemplo.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

import com.ejemplo.demo.constantes.ConstantesDemo;

@SpringBootApplication
@EnableReactiveMongoRepositories
@ComponentScan({ ConstantesDemo.PAQUETE_CONFIG, ConstantesDemo.PAQUETE_CONTROLADOR, ConstantesDemo.PAQUETE_SERVICIO })
public class MongoAplicacion {

	public static void main(String[] args) {
		SpringApplication.run(MongoAplicacion.class, args);
	}
}

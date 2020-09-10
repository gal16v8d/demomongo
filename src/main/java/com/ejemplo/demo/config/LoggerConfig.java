package com.ejemplo.demo.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

import com.ejemplo.demo.constantes.ConstantesDemo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Configuration
public class LoggerConfig {

	@Around("execution(* " + ConstantesDemo.PAQUETE_CONTROLADOR + ".EmpleadoControlador.*(..))")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		Object o = null;
		String nombreJP = joinPoint.getSignature().getName();
		long startTime = System.currentTimeMillis();
		log.info("Antes de: {}", nombreJP);
		o = joinPoint.proceed();
		log.info("Despues de: {}", nombreJP);
		long timeTaken = System.currentTimeMillis() - startTime;
		log.info("La petición {} tomo {} ms", nombreJP, timeTaken);
		return o;
	}

}

package co.com.gsdd.demo.mongo.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

import co.com.gsdd.demo.mongo.constants.DemoConstants;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Configuration
public class LoggerConfig {

	@Around("execution(* " + DemoConstants.CONTROLLER_PKG + ".EmployeeController.*(..))")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		Object o = null;
		String nombreJP = joinPoint.getSignature().getName();
		long startTime = System.currentTimeMillis();
		log.info("Before: {}", nombreJP);
		try {
			o = joinPoint.proceed();
		} catch (Exception e) {
			throw e;
		} finally {
			log.info("After: {}", nombreJP);
			long timeTaken = System.currentTimeMillis() - startTime;
			log.info("Execution of {} tooks {} ms", nombreJP, timeTaken);
		}
		return o;
	}

}

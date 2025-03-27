package com.okancezik.spring_boot.redis.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class LoggingAspect {
	@Pointcut("execution(* com.okancezik.spring_boot.redis.service.*.*.*(..))")
	public void serviceLayer() {
	}

	@Around("serviceLayer()")
	public Object logAroundMethod(ProceedingJoinPoint joinPoint) throws Throwable {
		String method = joinPoint.getSignature().getName();
		try {
			log.info("{} method has been called.", method);
			Object result = joinPoint.proceed();
			log.info("{} method worked successfully.", method);
			return result;
		} catch (Exception ex) {
			log.info("An error occurred in {} method.", method);
			throw ex;
		}
	}
}

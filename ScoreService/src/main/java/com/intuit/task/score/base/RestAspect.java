package com.intuit.task.score.base;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class RestAspect {
	
//	@Pointcut("within(com.intuit.task.score.rest.controller.ScoreConroller..*)")
	  @Pointcut("execution(* com.intuit.task.score.rest.controller.ScoreConroller.*(..))")
	private void controllerPointCut(){}
	
	@Around("controllerPointCut()")
    public Object  logAroundCreateEmployee(ProceedingJoinPoint joinPoint) throws Throwable 
    {
		long startTime = System.currentTimeMillis();
		Signature signature = joinPoint.getSignature();
        Object obj = joinPoint.proceed();
        log.info("rest service method:" +signature + " ,time:" + (System.currentTimeMillis() - startTime));
        return obj;
    }

	

}

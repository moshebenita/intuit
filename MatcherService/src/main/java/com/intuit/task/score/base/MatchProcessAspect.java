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
public class MatchProcessAspect {
	
    @Pointcut("within(com.intuit.task.score.customer.services.process..*)")
	private void processPointCut(){}
//	
	
	@Around("processPointCut()")
    public Object  logAroundCreateEmployee(ProceedingJoinPoint joinPoint) throws Throwable 
    {
		long startTime = System.currentTimeMillis();
		Signature signature = joinPoint.getSignature();
        Object obj = joinPoint.proceed();
        log.info("process method:" +signature + " ,time:" + (System.currentTimeMillis() - startTime));
        return obj;
    }

}

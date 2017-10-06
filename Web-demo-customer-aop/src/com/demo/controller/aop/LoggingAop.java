package com.demo.controller.aop;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;



@Aspect
@Component
public class LoggingAop {
	//setup logger
	private Logger myLogger = Logger.getLogger(getClass().getName());
	//setup point cut declareations
	@Pointcut("execution(* com.demo.controller.*.*(..))")
	private void forController() {}
	
	// do the same for service and dao
	@Pointcut("execution(* com.demo.service.*.*(..))")
	private void forService() {}
	
	
	@Pointcut("execution(* com.demo.dao.*.*(..))")
	private void forDao() {}
	
	@Pointcut("forController() || forService() || forDao()")
	private void forAppFlow() {}
	
	
	//add @before advice
	@Before("forAppFlow()") 
	public void before(JoinPoint theJoinPoint) {
		//the play the medthod being call
	//	System.out.println("aaaaa");
		String theMethod = theJoinPoint.getSignature().toShortString();
		myLogger.info("====>>>> in @Before: calling method: "+ theMethod);
	}
	//ad @AfterReturning advice
}

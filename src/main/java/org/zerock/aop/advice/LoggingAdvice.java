package org.zerock.aop.advice;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j;

@Log4j
@Aspect
@Component
public class LoggingAdvice{
	//하나의 joinpoint에 pointcutB(Before..등) 이 2개이상 지정되면 안됨
//	@Before("execution(* org.zerock.aop.service.AopService*.*(..)")
//	public void logBefore() {
//		log.info("Before ======================");
//	}
	
	@Before("execution(* org.zerock.aop.service.AopService*.aopTestMethod(String, String))&& args(param1,param2)")
	public void logBeforeWithParam(String param1 , String param2) {
		log.info("Before With Param ======================");
		log.info(param1);
		log.info(param2);
	}
	
	@Around("execution(* org.zerock.aop.service.AopService*.*(..))")
	public Object logTime(ProceedingJoinPoint pjp){
		long start = System.currentTimeMillis();
		
		log.info("Target : "+pjp.getTarget());
		log.info("Param : "+Arrays.toString(pjp.getArgs()));
		
		Object result = null;
			try {
				result = pjp.proceed();
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		long end = System.currentTimeMillis();
		
		log.info("TIME :" + (end-start));
		
		return result;
	}
}

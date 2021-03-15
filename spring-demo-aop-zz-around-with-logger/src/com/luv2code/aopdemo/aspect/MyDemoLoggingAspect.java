package com.luv2code.aopdemo.aspect;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
	
	private Logger myLogger=Logger.getLogger(getClass().getName());
	
	@Around("execution(* com.luv2code.aopdemo.service.*.getFortunee(..))")
	public Object aroundGetFortune(ProceedingJoinPoint theProceedingJoinPoint)
			throws Throwable {
		String method=theProceedingJoinPoint.getSignature().toShortString();
		myLogger.info("\n===>>>Excuting @Around Advice on method: "+method);
		
		long begin=System.currentTimeMillis();
		Object result=theProceedingJoinPoint.proceed();
		
		long end=System.currentTimeMillis();
		
		long duration=end-begin;
		
		myLogger.info("\n====>Duration  "+ duration);
		
		return result;
	}
	
	@After("execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinally(JoinPoint theJoinPoint) {
		String method=theJoinPoint.getSignature().toShortString();
		 myLogger.info("\n===>>>Excuting @After Finally Advice on method: "+method);
		
	}
	
	@AfterThrowing(pointcut="execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
			throwing="theExc")
	public void afterThrowing(JoinPoint theJoinPoint, Throwable theExc) {
		String method=theJoinPoint.getSignature().toShortString();
		 myLogger.info("\n===>>>Excuting @AfterThowing Advice on method: "+method);
		 myLogger.info("\n===>>>Excuting @Exception is: "+theExc);
		 
	}

	@AfterReturning(pointcut="execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
			returning="result")
	 public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint,List<Account> result) {
		 String method=theJoinPoint.getSignature().toShortString();
		 myLogger.info("\n===>>>Excuting @AfterReturning Advice on method: "+method);
		 myLogger.info("\n===>>>Excuting @result is: "+result);
		 
		 covertAccountNamesToUpperCase(result);
		 myLogger.info("\n===>>>Excuting @result is: "+result);
	 }
	
	
	private void covertAccountNamesToUpperCase(List<Account> result) {
		// TODO Auto-generated method stub
		for(Account a:result) {
			a.setName(a.getName().toUpperCase());
			
		}
	}


	@Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		myLogger.info("\n===>>>Excuting @Before Advice on addAccount()");
		
		//method signature
		MethodSignature sig=(MethodSignature) theJoinPoint.getSignature();
		myLogger.info("Method: " + sig);
		
		//method argu
		Object[] args=theJoinPoint.getArgs();
		for(Object a:args) {
			myLogger.info("arg: " + a);
			if(a instanceof Account) {
				Account aa=(Account) a;
				myLogger.info("acoct name  "+ aa.getName());
				myLogger.info("service code  "+ aa.getLevel());
			}
		}
	}
	
}

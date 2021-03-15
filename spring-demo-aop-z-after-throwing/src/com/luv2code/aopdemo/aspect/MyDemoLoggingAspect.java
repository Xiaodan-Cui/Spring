package com.luv2code.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
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
	@AfterThrowing(pointcut="execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
			throwing="theExc")
	public void afterThrowing(JoinPoint theJoinPoint, Throwable theExc) {
		String method=theJoinPoint.getSignature().toShortString();
		 System.out.println("\n===>>>Excuting @AfterThowing Advice on method: "+method);
		 System.out.println("\n===>>>Excuting @Exception is: "+theExc);
		 
	}

	@AfterReturning(pointcut="execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
			returning="result")
	 public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint,List<Account> result) {
		 String method=theJoinPoint.getSignature().toShortString();
		 System.out.println("\n===>>>Excuting @AfterReturning Advice on method: "+method);
		 System.out.println("\n===>>>Excuting @result is: "+result);
		 
		 covertAccountNamesToUpperCase(result);
		 System.out.println("\n===>>>Excuting @result is: "+result);
	 }
	
	
	private void covertAccountNamesToUpperCase(List<Account> result) {
		// TODO Auto-generated method stub
		for(Account a:result) {
			a.setName(a.getName().toUpperCase());
			
		}
	}


	@Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		System.out.println("\n===>>>Excuting @Before Advice on addAccount()");
		
		//method signature
		MethodSignature sig=(MethodSignature) theJoinPoint.getSignature();
		System.out.println("Method: " + sig);
		
		//method argu
		Object[] args=theJoinPoint.getArgs();
		for(Object a:args) {
			System.out.println("arg: " + a);
			if(a instanceof Account) {
				Account aa=(Account) a;
				System.out.println("acoct name  "+ aa.getName());
				System.out.println("service code  "+ aa.getLevel());
			}
		}
	}
	
}

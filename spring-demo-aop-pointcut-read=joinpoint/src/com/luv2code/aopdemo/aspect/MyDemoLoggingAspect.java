package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
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

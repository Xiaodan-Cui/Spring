package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {
public static void main(String[] args) {
	//load the spring config file
	ClassPathXmlApplicationContext context=
			new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");
	
	//retrieve bean from spring container
			
	Coach theCoach = context.getBean("myCoach", Coach.class);
	Coach alphaCoach = context.getBean("myCoach", Coach.class);
	
	//check if they are the same;
	
	boolean result =(theCoach==alphaCoach);
	
	System.out.println("\npoint tot to the same obj" + result);
	System.out.println("\nloc of theCoach" + theCoach);
	System.out.println("\nloc of alpahCoach" + alphaCoach);
	
	context.close();
	
}
}

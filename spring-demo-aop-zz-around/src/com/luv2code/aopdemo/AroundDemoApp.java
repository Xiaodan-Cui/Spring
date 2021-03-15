package com.luv2code.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;
import com.luv2code.aopdemo.service.TrafficFortuneService;


public class AroundDemoApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context=
				new AnnotationConfigApplicationContext(DemoConfig.class);
		TrafficFortuneService theService=context.getBean("trafficFortuneService", TrafficFortuneService.class);
		System.out.println("Around Calling getFortune");
		
		String data=theService.getFortunee();
		
		System.out.println("\n"+data);

		context.close();
	}

}

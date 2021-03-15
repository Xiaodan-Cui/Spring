package com.luv2code.aopdemo;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;
import com.luv2code.aopdemo.service.TrafficFortuneService;


public class AroundDemoApp {
	
	private static Logger myLogger=
			Logger.getLogger(AroundWithLoggerDemoApp.class.getName());

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context=
				new AnnotationConfigApplicationContext(DemoConfig.class);
		TrafficFortuneService theService=context.getBean("trafficFortuneService", TrafficFortuneService.class);
		myLogger.info("Around Calling getFortune");
		
		String data=theService.getFortunee();
		
		myLogger.info("\n"+data);

		context.close();
	}

}

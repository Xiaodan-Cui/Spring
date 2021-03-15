package com.luv2code.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component

public class TennisCoach implements Coach {
	@Autowired
	@Qualifier("randomService")
	private FortuneService fortuneService;
//	@Autowired
//	public TennisCoach(FortuneService theFortuneService) {
//		fortuneService=theFortuneService;
//	}
	
	public TennisCoach() {
		System.out.println("inside defulat constructore");
	}
	//define init method
	@PostConstruct
	public void doMyStartupStuff() {
		System.out.println("inside do my startup");
	}
	@PreDestroy
	public void doMyCleanupStuff() {
		System.out.println("inside do my clean up");
	}
	
	
	//define destroy method
	
//	@Autowired
//	public void sddsd(FortuneService theFortuneService) {
//		System.out.println("inside sdsds une");
//		fortuneService=theFortuneService;
//	}
	@Override
	public String getDailyWorkOut() {
	
		return "Practice your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

}

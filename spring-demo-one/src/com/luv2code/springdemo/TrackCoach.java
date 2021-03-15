package com.luv2code.springdemo;

public class TrackCoach implements Coach {

	private FortuneService fortuneServices;
	
	public TrackCoach(FortuneService fortuneServices) {
		super();
		this.fortuneServices = fortuneServices;
	}

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Run a hard 5k";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return "Just Do It:"+fortuneServices.getFortune();
	}
	//add init method
	
	public void doMyStartupStuff() {
		System.out.println("Trackcoach inside init mdo start up ");
	}
	public void doMyCleanupStuff() {
		System.out.println("Trackcoach inside doMyCleanupStuff");
	}

}

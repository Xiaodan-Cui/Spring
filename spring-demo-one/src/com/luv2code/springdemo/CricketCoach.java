package com.luv2code.springdemo;

public class CricketCoach implements Coach {
	private FortuneService fortuneService;
	private String emailAddress;
	private String team;
	
	public CricketCoach(){
		System.out.println("cricketcoach:inside no-config arg");
	}
	


	public String getEmailAddress() {
		return emailAddress;
	}



	public void setEmailAddress(String emailAddress) {
		System.out.println("cricketcoah:inside setter method - set Email Address");
		this.emailAddress = emailAddress;
	}



	public String getTeam() {
		return team;
	}



	public void setTeam(String team) {
		System.out.println("cricketcoah:inside setter method - set team");
		this.team = team;
	}



	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("cricketcoah:inside setter method - setFortuneService");
		this.fortuneService = fortuneService;
	}





	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "cricktewor out";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

}

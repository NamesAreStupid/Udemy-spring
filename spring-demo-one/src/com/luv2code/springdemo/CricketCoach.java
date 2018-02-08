package com.luv2code.springdemo;

public class CricketCoach implements Coach {
	
	private FortuneService fortuneService;
	private String emailAddress;
	private String team;

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		System.out.println("CricketCoach: inside setter method - setTeam.");
		this.team = team;
	}

	public void setEmailAddress(String emailAddress) {
		System.out.println("CricketCoach: inside setter method - setEmailAddress.");
		this.emailAddress = emailAddress;
	}

	public CricketCoach() {
		System.out.println("CricketCoach: inside no-arg constructor.");
	}

	// our setter method
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("CricketCoach: inside setter method - setFortuneService.");
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Practice fast bowling for 15 minutes.";
	}

	public String getEmailaddress() {
		return emailAddress;
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}

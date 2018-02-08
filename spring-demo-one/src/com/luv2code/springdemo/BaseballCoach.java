package com.luv2code.springdemo;

public class BaseballCoach implements Coach {
	
	//define private field for the dependency
	private FortuneService fortuneService;
	
	// define a constructor for the dependency injection
	public BaseballCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Spend 30 Minutes on batting practice.";
	}

	@Override
	public String getDailyFortune() {
		// use my fortune Service
		return fortuneService.getFortune();
	}
}

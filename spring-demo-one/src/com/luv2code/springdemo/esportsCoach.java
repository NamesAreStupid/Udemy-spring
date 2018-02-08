package com.luv2code.springdemo;

public class esportsCoach implements Coach {
	
	private FortuneService fortuneService;

	public esportsCoach(FortuneService fortuneService) {
		super();
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Play some games, Yo!";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}

package com.luv2code.springdemo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

	private String[] fortunes = {
			"Buddha smiles on you today!",
			"Today is your lucky day!",
			"The journey is the reward!"
		};
	
	private Random random = new Random();
	
	@Override
	public String getFortune() {
		return fortunes[random.nextInt(fortunes.length)];
	}

}

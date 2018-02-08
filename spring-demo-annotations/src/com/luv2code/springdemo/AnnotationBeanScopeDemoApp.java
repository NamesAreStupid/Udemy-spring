package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {

	public static void main(String[] args) {
		
		try(ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml")) {
			
			Coach coach = context.getBean("tennisCoach", Coach.class);
			Coach alphaCoach = context.getBean("tennisCoach", Coach.class);
			
			boolean result = coach == alphaCoach;
			
			System.out.println("Pointing to the same object: " + result);
			System.out.println(coach);
			System.out.println(alphaCoach);

		}
	}

}

package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.ui.context.Theme;

public class BeanLifecycleDemoApp {

	public static void main(String[] args) {
		
		// load the spring config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanLifecycle-applicationContext.xml");
		
		// retrieve bean from spring container
		Coach coach = context.getBean("myCoach", Coach.class);
		
		System.out.println(coach.getDailyWorkout());
		
		// close the context
		context.close();
		
	}

}

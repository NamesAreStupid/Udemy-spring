package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.ui.context.Theme;

public class BeanScopeDemoApp {

	public static void main(String[] args) {
		
		// load the spring config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");
		
		// retrieve bean from spring container
		Coach coach = context.getBean("myCoach", Coach.class);
		
		Coach alphaCoach = context.getBean("myCoach", Coach.class);
		
		// check of they are the same
		boolean result = coach == alphaCoach;
		
		// print the result
		System.out.println("\nPointing to the same object " + result);
		System.out.println("\nMemory location for coach: " + coach);
		System.out.println("\nMemory location for alphaCoach: " + alphaCoach);
		
		// close the context
		context.close();
		
		
	}

}

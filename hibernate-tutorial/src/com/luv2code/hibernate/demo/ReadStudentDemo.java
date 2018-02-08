package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {

		//create session factory	
		try(SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory(); ) {
			
			// create session
			Session session = factory.getCurrentSession();
			
			// create student object
			System.out.println("creating new student object");
			Student tmpStudent = new Student("Paul", "Wall", "paul@luv2code.com");
			Student tmpStudent2 = new Student("Mary", "Poppins", "mary@luv2code.com");
			Student tmpStudent3 = new Student("Bonita", "Applebaum", "bonita@luv2code.com");

			// start transaction
			session.beginTransaction();
			
			// save student object
			System.out.println("saving the students...");
			session.save(tmpStudent);
			session.save(tmpStudent2);
			session.save(tmpStudent3);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		} 
		
	}
	
}

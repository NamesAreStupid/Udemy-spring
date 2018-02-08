package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {

		//create session factory	
		try(SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory(); ) {
			
			// create session
			Session session = factory.getCurrentSession();

			session = factory.getCurrentSession();
			session.beginTransaction();
			List<Student> students = session.createQuery("from Student").getResultList();
//			students.forEach(s -> System.out.println(s.getFirstName()));
//			
//			students = session.createQuery("from Student s where s.lastName='Duck'").getResultList();
//			students.forEach(s -> System.out.println(s.getFirstName()));
//			
//			students = session.createQuery("from Student s where s.lastName='Doe' OR s.firstName='Daffy'").getResultList();
//			students.forEach(s -> System.out.println(s.getFirstName()));
			
			students = session.createQuery("from Student s where s.email LIKE '%luv2code.com'").getResultList();
			students.forEach(s -> System.out.println(s.getFirstName()));
			
			session.getTransaction().commit();
			
			System.out.println("Done!");
		} 
		
	}
	
}

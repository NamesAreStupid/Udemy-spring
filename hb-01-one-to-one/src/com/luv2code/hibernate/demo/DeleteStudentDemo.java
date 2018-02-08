package com.luv2code.hibernate.demo;

import java.util.List;
import java.util.function.Consumer;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {

		wrapTransaction( s -> {
			Student student = s.get(Student.class, 7);
			s.delete(student);
		});

		
	}
	
	public static void wrapTransaction(Consumer<Session> consumer) {
		try(SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory(); ) {
			// create session
			Session session = factory.getCurrentSession();
			session.beginTransaction();
			
			consumer.accept(session);
			
			session.getTransaction().commit();
		}
	}
	
}

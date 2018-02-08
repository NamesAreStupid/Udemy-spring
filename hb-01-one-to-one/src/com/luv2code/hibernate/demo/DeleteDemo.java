package com.luv2code.hibernate.demo;

import java.util.function.Consumer;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.entity.Instructor;
import com.luv2code.hibernate.entity.InstructorDetail;
import com.luv2code.hibernate.entity.Student;

public class DeleteDemo {

	public static void main(String[] args) {

		wrapTransaction( (s) -> {
			int id = 1;
			Instructor instructor = s.get(Instructor.class, id);
			if(instructor != null) {
				s.delete(instructor);
			}
		} );

	}
	
	public static void wrapTransaction(Consumer<Session> consumer) {
		try(SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory(); ) {
			Session session = factory.getCurrentSession();
			session.beginTransaction();
			
			// wrapped code
			consumer.accept(session);
			
			session.getTransaction().commit();
		}
	}

}

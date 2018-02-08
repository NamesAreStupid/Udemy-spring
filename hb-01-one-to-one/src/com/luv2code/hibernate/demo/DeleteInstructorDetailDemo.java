package com.luv2code.hibernate.demo;

import java.util.function.Consumer;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.SharedSessionContract;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.entity.Instructor;
import com.luv2code.hibernate.entity.InstructorDetail;
import com.luv2code.hibernate.entity.Student;

public class DeleteInstructorDetailDemo {

	public static void main(String[] args) {

		wrapTransaction( (s) -> {
			int id = 4;
			InstructorDetail detail = s.get(InstructorDetail.class, id);
			detail.getInstructor().setInstructorDetail(null);
			s.delete(detail);
		} );

	}
	
	public static void wrapTransaction(Consumer<Session> consumer) {
		try(SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory(); 
			Session session = factory.getCurrentSession(); ) {
			
			session.beginTransaction();
			
			// wrapped code
			consumer.accept(session);
			
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}

}

package com.luv2code.hibernate.demo;

import java.util.function.Consumer;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.entity.Course;
import com.luv2code.hibernate.entity.Instructor;
import com.luv2code.hibernate.entity.InstructorDetail;

public class OneToManyDemo {

	public static void main(String[] args) {
		
		Instructor instructor = new Instructor("Chad", "Darby", " darby@luv2code.com");
		InstructorDetail detail = new InstructorDetail("http://www.luv2code.com/youtube", "Luv 2 code!!!");
		Course course = new Course("Spring Masterclass");
		
		instructor.setInstructorDetail(detail);
		instructor.add(course);

		wrapTransaction( (s) -> {
			s.saveOrUpdate(instructor);
//			s.save(course);
		} );

	}
	
	public static void wrapTransaction(Consumer<Session> consumer) {
		try(SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Course.class)
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

package com.luv2code.hibernate.demo;

import java.util.function.Consumer;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {

		wrapTransaction( s -> {
			Student student = s.get(Student.class, 1);
			student.setFirstName("Paul");
			System.out.println(student);
		});
//		wrapTransaction( s -> {
//			s.createQuery("update Student set email='foo@gmail.com'")
//			 .executeUpdate();
//		});
//		wrapTransaction(new Consumer<Session>() {
//			@Override
//			public void accept(Session t) {
//				Student tmp = t.get(Student.class, 1);
//				System.out.println(t);
//			}
//		});
		
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

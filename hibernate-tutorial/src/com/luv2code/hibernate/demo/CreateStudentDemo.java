package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {

		//create session factory	
		try(SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory(); ) {
			
			// create session
			Session session = factory.getCurrentSession();
//			
//			// create student object
//			System.out.println("creating new student object");
//			Student tmpStudent = new Student("Daffy", "Duck", "paul@luv2code.com");
//
//			// start transaction
//			session.beginTransaction();
//			
//			// save student object
//			System.out.println("saving the students...");
//			session.save(tmpStudent);
//			
//			// commit transaction
//			session.getTransaction().commit();
//			
//			//find out id
//			System.out.println("saved student. Generated id: " + tmpStudent.getId());
//			
//			session = factory.getCurrentSession();
//			session.beginTransaction();
//			System.out.println("Getting student with if: " + tmpStudent.getId());
//			Student myStudent = session.get(Student.class, tmpStudent.getId());
//			System.out.println("Get complete: " + myStudent);
//			session.getTransaction().commit();
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			List<Student> students = session.createQuery("from Student").getResultList();
			students.forEach(s -> System.out.println(s.getFirstName()));
			session.getTransaction().commit();
			
			System.out.println("Done!");
		} 
		
	}
	
}

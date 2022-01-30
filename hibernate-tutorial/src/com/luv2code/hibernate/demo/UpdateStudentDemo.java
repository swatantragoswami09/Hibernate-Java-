package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.lu2code.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		
//		create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
//		create session
		Session session = factory.getCurrentSession();
		
		try {

			int studentId=1;
			
//			now get a new session and start transaxcxtion
			session = factory.getCurrentSession();
			session.beginTransaction();
			
//			retrive student bases on the id:primary key
			System.out.println("\n Getting student with id:"+studentId);
			Student myStudent = session.get(Student.class, studentId);
			System.out.println("Updating Student..: ");
			myStudent.setFirstName("scooby");
						
			
//			commit the transaction
			session.getTransaction().commit();
//			New code 
			session = factory.getCurrentSession();
			session.beginTransaction();
			
//			updating email for all students
			System.out.println("Updating email for all students");
			
			session.createQuery("update Student set email='foo@gmail.com'").executeUpdate();
//commi the transaction			
			session.getTransaction().commit();
			
			System.out.println("Done!");		
			
		}finally{
			factory.close();
		}

	}

}

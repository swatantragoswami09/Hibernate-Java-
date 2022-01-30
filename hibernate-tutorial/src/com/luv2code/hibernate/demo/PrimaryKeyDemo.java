package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.lu2code.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		
//		create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
//		create session
		Session session = factory.getCurrentSession();
		
		try {

//			create 3 student objects
			System.out.println("creating new student object....");
			Student tempStudent1=new Student("John","Doe","john@gmail.com");
			Student tempStudent2=new Student("Mary","Public","mary@gmail.com");
			Student tempStudent3=new Student("Bonita","Applebaum","bonita@gmail.com");
			
//			start a transaction
			session.beginTransaction();
			
//			save the student object
			System.out.println("saving the student....");
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);
						
//			commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");		
			
		}finally{
			factory.close();
		}

	

	}

}

package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.lu2code.hibernate.demo.entity.Course;
import com.lu2code.hibernate.demo.entity.Instructor;
import com.lu2code.hibernate.demo.entity.InstructorDetail;

public class EagerLazyDemo {

	public static void main(String[] args) {

//		create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(Course.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

//		create session
		Session session = factory.getCurrentSession();

		try {

			// start a transaction
			session.beginTransaction();

			// get hte instructor from db
			int theId = 1;
			Instructor tempInstructor = session.get(Instructor.class, theId);
			System.out.println("luv2code: Instructor:" + tempInstructor);

			// get course for the instructor
			System.out.println("luv2code: Course: " + tempInstructor.getCourse());

			// commit transaction
			session.getTransaction().commit();

//			close the session
			session.close();

			System.out.println("luv2code : The session is now closed!\n");
//			option 1:call getter and setter

			System.out.println("luv2code: Done!");

		} finally {
//			add clean up code
			session.close();
			factory.close();
		}

	}

}

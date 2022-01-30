package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.lu2code.hibernate.demo.entity.Course;
import com.lu2code.hibernate.demo.entity.Instructor;
import com.lu2code.hibernate.demo.entity.InstructorDetail;

public class CreateInstructorDemo {

	public static void main(String[] args) {

//		create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(Course.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

//		create session
		Session session = factory.getCurrentSession();

		try {

			// create the objects
			Instructor tempInstructor = new Instructor("Susan", "Public", "susan.public@luv2code.com");

			InstructorDetail tempInstructorDetail = new InstructorDetail("https://www.youtube.com/channel/youtube",
					"video game");

			// associate the objects
			tempInstructor.setInstructorDetail(tempInstructorDetail);

			// start a transaction
			session.beginTransaction();

			// save the instructor
//			
//			Note: this will also save the details object
//			because to cascadeType.ALL
			System.out.println("Saving instructor:" + tempInstructor);
			session.save(tempInstructor);

			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");

		} finally {
//			add clean up code
			session.close();
			factory.close();
		}

	}

}

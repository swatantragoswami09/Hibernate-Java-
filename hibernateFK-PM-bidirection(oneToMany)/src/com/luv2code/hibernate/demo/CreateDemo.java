package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.lu2code.hibernate.demo.entity.Instructor;
import com.lu2code.hibernate.demo.entity.InstructorDetail;

public class CreateDemo {

	public static void main(String[] args) {

//		create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

//		create session
		Session session = factory.getCurrentSession();

		try {

//			// create the objects
//			Instructor tempInstructor = new Instructor("Chad", "Darby", "darby@luv2code.com");
//
//			InstructorDetail tempInstructorDetail = new InstructorDetail(
//					"https://www.youtube.com/channel/UCd9Lb7BGkdtu6wIp7KtEJsg", "luv 2 code!!");

			// create the objects
			Instructor tempInstructor = new Instructor("Madhu", "Patel", "madhu@luv2code.com");

			InstructorDetail tempInstructorDetail = new InstructorDetail("https://www.youtube.com/channel/youtube",
					"luv 2 code!!");

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
			factory.close();
		}

	}

}

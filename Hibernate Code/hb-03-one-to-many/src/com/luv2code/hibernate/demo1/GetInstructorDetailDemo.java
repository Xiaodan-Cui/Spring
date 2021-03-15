package com.luv2code.hibernate.demo1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class GetInstructorDetailDemo {

	public static void main(String[] args) {
		SessionFactory factory=new Configuration() 
						.configure("hibernate.cfg.xml")
						.addAnnotatedClass(Instructor.class)
						.addAnnotatedClass(InstructorDetail.class)
						.buildSessionFactory();
		Session session=factory.getCurrentSession();
		try {
			session.beginTransaction();
			int theId =13 ;
			InstructorDetail tempD=session.get(InstructorDetail.class, theId);
			System.out.println(tempD+"   "+tempD.getInstructor());
			
			session.getTransaction().commit();;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
			factory.close();
		}

	}

}

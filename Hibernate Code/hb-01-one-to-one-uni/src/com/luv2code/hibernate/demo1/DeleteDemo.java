package com.luv2code.hibernate.demo1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class DeleteDemo {

	public static void main(String[] args) {
		SessionFactory factory=new Configuration() 
						.configure("hibernate.cfg.xml")
						.addAnnotatedClass(Instructor.class)
						.addAnnotatedClass(InstructorDetail.class)
						.buildSessionFactory();
		Session session=factory.getCurrentSession();
		try {
			session.beginTransaction();
			int theId=2;
			Instructor tempI=session.get(Instructor.class,theId);
			if(tempI!=null) {
				System.out.println("deleted");
				session.delete(tempI);
			}
			

			session.getTransaction().commit();;
		}
		finally {
			session.close();
			factory.close();
		}

	}

}

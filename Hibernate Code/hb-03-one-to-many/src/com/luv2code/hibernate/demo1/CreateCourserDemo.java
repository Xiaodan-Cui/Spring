package com.luv2code.hibernate.demo1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class CreateCourserDemo {

	public static void main(String[] args) {
		SessionFactory factory=new Configuration() 
						.configure("hibernate.cfg.xml")
						.addAnnotatedClass(Instructor.class)
						.addAnnotatedClass(InstructorDetail.class)
						.addAnnotatedClass(Course.class)
						.buildSessionFactory();
		Session session=factory.getCurrentSession();
		try {
			session.beginTransaction();
			
			int theId=1;
			Instructor tempI= session.get(Instructor.class, theId);
			Course tempC=new Course("Guitaarrrrrr");
			Course tempC2=new Course("Dancccceeee");
			tempI.add(tempC);
			tempI.add(tempC2);
			session.save(tempC);
			session.save(tempC2);
			
			
		
			//System.out.println("Saved  "+ tempIns+" "+tempDet);

			session.getTransaction().commit();;
		}
		finally {
			session.close();
			factory.close();
		}

	}

}

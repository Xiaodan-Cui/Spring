package com.luv2code.hibernate.demo1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class CreateDemo {

	public static void main(String[] args) {
		SessionFactory factory=new Configuration() 
						.configure("hibernate.cfg.xml")
						.addAnnotatedClass(Instructor.class)
						.addAnnotatedClass(InstructorDetail.class)
						.buildSessionFactory();
		Session session=factory.getCurrentSession();
		try {
			Instructor tempIns=new Instructor("fdfsf","dfsdI","434edy@lub2code.com");
			InstructorDetail tempDet=new InstructorDetail("http://www.a3t4rfdd.com/youtube","loce");
			tempIns.setInstructorDetail(tempDet);
			
			session.beginTransaction();
			
			session.save(tempIns);
			System.out.println("Saved  "+ tempIns+" "+tempDet);

			session.getTransaction().commit();;
		}
		finally {
			session.close();
			factory.close();
		}

	}

}

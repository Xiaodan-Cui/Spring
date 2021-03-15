package com.luv2code.hibernate.demo1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class GetCoursesFroMaryDemo {

	public static void main(String[] args) {
		SessionFactory factory=new Configuration() 
						.configure("hibernate.cfg.xml")
						.addAnnotatedClass(Instructor.class)
						.addAnnotatedClass(InstructorDetail.class)
						.addAnnotatedClass(Course.class)
						.addAnnotatedClass(Review.class)
						.addAnnotatedClass(Student.class)
						.buildSessionFactory();
		Session session=factory.getCurrentSession();
		try {
			session.beginTransaction();
			
			int theId=2;
			Student s1=session.get(Student.class, theId);
			
			System.out.println(s1);
			System.out.println(s1.getCourses());
			
			Course c1=new Course("fdgff");
			Course c2=new Course("sdfsfdsd");
			
			c1.addStudent(s1);
			c2.addStudent(s1);
			
			session.save(c1);
			session.save(c2);
			
			
			session.getTransaction().commit();
		}
		finally {
			session.close();
			factory.close();
		}

	}

}

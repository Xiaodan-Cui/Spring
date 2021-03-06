package com.luv2code.hibernate.demo1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;

public class CreateCourseAndReviewsDemo {

	public static void main(String[] args) {
		SessionFactory factory=new Configuration() 
						.configure("hibernate.cfg.xml")
						.addAnnotatedClass(Instructor.class)
						.addAnnotatedClass(InstructorDetail.class)
						.addAnnotatedClass(Course.class)
						.addAnnotatedClass(Review.class)
						.buildSessionFactory();
		Session session=factory.getCurrentSession();
		try {
			session.beginTransaction();
			Course tempCourse= new Course("Hello-say hi");
			tempCourse.addReview(new Review("GODD COURser"));
			tempCourse.addReview(new Review("ADFDFDFDF"));
			tempCourse.addReview(new Review("etry ferthtgrfde"));
			tempCourse.addReview(new Review("ret65465tgrfvd fs gfdfs"));
			tempCourse.addReview(new Review("regbfd bfgdgfds"));
			session.save(tempCourse);
			System.out.println(tempCourse);
			System.out.println(tempCourse.getReviews());
			
			
		
			//System.out.println("Saved  "+ tempIns+" "+tempDet);

			session.getTransaction().commit();;
		}
		finally {
			session.close();
			factory.close();
		}

	}

}

package com.luv2code.hibernate.demo1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateCourseAndStudentDemo {

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
			Course tempCourse= new Course("Hello-say hi");
			session.save(tempCourse);
			System.out.println(tempCourse);
			Student s1=new Student("fdf","fdsgfdg","rrtgr@#fdsf");
			Student s2=new Student("fdsfdsfd","e43","efrfr@#fdsf");
			Student s3=new Student("3454","fdg","e43tfgc@#fdsf");
			tempCourse.addStudent(s1);
			tempCourse.addStudent(s2);
			tempCourse.addStudent(s3);
			session.save(s1);
			session.save(s2);
			session.save(s3);
			
			
			System.out.println(tempCourse.getStudents());
			
			
		
			//System.out.println("Saved  "+ tempIns+" "+tempDet);

			session.getTransaction().commit();
		}
		finally {
			session.close();
			factory.close();
		}

	}

}

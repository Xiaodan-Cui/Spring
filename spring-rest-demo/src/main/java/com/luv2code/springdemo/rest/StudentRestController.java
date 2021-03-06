package com.luv2code.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	private  List<Student> students;
	
	@PostConstruct
	public void loadData() {
		students = new ArrayList();
		students.add(new Student("fdsfs","ret"));
		students.add(new Student("fdsfdss","reretred"));
		students.add(new Student("3432s","7ygfd"));
	}
	
	@GetMapping("/students")
	public List<Student> getStudents(){
		loadData();
		return students;
	}
	
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId){
		if(studentId>=students.size() || studentId<0) {
			throw new StudentNotFoundException("Student id not Found: "+studentId);
		}
		return students.get(studentId);
	}
	

}

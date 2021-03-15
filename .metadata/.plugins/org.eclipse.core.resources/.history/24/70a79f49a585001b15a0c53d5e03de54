package com.luv2code.springboot.thymeleafdemo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luv2code.springboot.thymeleafdemo.model.Employee;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	private List<Employee> theEmployees;
	
	
	@PostConstruct
	private void loadDate() {
		Employee a=new Employee(1,"dsf","retret","rtf@fdgfds.cpm");
		Employee b=new Employee(2,"r543","654","6e@retc");
		Employee c=new Employee(3,"45","ytryuytre","yretwQ@tre4");
		theEmployees =new ArrayList();
		theEmployees.add(a);
		theEmployees.add(b);
		theEmployees.add(c);	
	}
	
	@GetMapping("/list")
	public String listEmployees(Model theModel) {
		theModel.addAttribute("employees",theEmployees);
		return "list-employees";
	}
	
}

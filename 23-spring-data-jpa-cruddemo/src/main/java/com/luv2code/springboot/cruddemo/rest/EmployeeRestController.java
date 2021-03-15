package com.luv2code.springboot.cruddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.luv2code.springboot.cruddemo.entity.Employee;
import com.luv2code.springboot.cruddemo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	private EmployeeService employeeService;
	
	@Autowired
	public EmployeeRestController(EmployeeService theEmployeeService) {
		employeeService=theEmployeeService;
	}
	
	@GetMapping("/employees")
	public List<Employee> findAll(){
		return employeeService.findAll();
	}
	
	@GetMapping("/employees/{employeeId}")
	public Employee findEmplyeeById(@PathVariable int employeeId){
		
		Employee theEmp= employeeService.findEmployeeById(employeeId);
		
		if(theEmp==null) {
			throw new RuntimeException("id not found");
		}
		return theEmp;
	}
	
	@PutMapping("/employees")
	public Employee addEmployee(@RequestBody Employee theEmp){
		
		employeeService.save(theEmp);
		
		return theEmp;
	}
	@DeleteMapping("/employees/{employeeId}")
	public String deleteEmplyeeById(@PathVariable int employeeId){
		
		Employee theEmp= employeeService.findEmployeeById(employeeId);
		
		if(theEmp==null) {
			throw new RuntimeException("id not found");
		}
		employeeService.deleteById(employeeId);
		return "deleted"+employeeId;
	}
}

package com.luv2code.springdemo.rest;

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

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerRestController {
	@Autowired
	private CustomerService customerService;
	
	
	@GetMapping("/customers")
	private List<Customer> getCustomers(){
		return customerService.getCustomers();
	}
	
	@GetMapping("/customers/{customerId}")
	private Customer getCustomer(@PathVariable int customerId){
		Customer customer=customerService.getCustomer(customerId);
		if(customer==null) {
			throw new CustomerNotFoundException("Customer Id not Found - "+ customerId);
		}
		return customer;
	}
	
	@PostMapping("/customers")
	private Customer addCustomer(@RequestBody Customer theCustomer){
		theCustomer.setId(0);
		customerService.saveCustomer(theCustomer);
		return theCustomer;
	}
	
	@PutMapping("/customers")
	private Customer updateCustomer(@RequestBody Customer theCustomer){
		
		customerService.saveCustomer(theCustomer);
		return theCustomer;
	}
	
	@DeleteMapping("/customers/{customerId}")
	private String deleteCustomer(@PathVariable int customerId){
		Customer cus=customerService.getCustomer(customerId);
		if(cus==null) {
			throw new CustomerNotFoundException("Customer Id not Found - "+ customerId);
		}
		customerService.deleteCustomer(customerId);
		return "Deleted:"+customerId;
	}
}

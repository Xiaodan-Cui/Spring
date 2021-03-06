package com.luv2code.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {
	
	// need a controller method to show the initial html form
@RequestMapping("/showForm")
	public String showFrom() {
		return "helloworld-form";
	}


@RequestMapping("/processForm")
public String processFrom() {
	return "helloworld";
}


@RequestMapping("/processFormTwo")
public String letsShoutDude(HttpServletRequest request, Model model) {
	//read the request parameter from the HTML form
	String theName= request.getParameter("studentName");
	//convert the data to all caps
	theName=theName.toUpperCase();
	//create the messaget
	
	String result="Yo!" + theName;
	
	//add messaget to the modle 
			
	model.addAttribute("message",result);
	
	return "helloworld";
}

@RequestMapping("/processFormThree")
public String processFormVersionThree(
		@RequestParam("studentName") String theName, 
		Model model) {
	//read the request parameter from the HTML form
	
	//convert the data to all caps
	theName=theName.toUpperCase();
	//create the messaget
	
	String result="Yoyoyoyo!" + theName;
	
	//add messaget to the modle 
			
	model.addAttribute("message",result);
	
	return "helloworld";
}

}


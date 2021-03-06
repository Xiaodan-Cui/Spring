package com.luv2code.springboot.demo.GoodApp.rest;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
	
	@Value("${coach.name}")
	private String coachName;
	
	@Value("${team.name}")
	private String teamName;
	
	
	@GetMapping("/teaminfo")
	public String teamInfo() {
		return "Coach:" + coachName + "  Team: "+ teamName;
	}
	
	@GetMapping("/")
	public String sayHello() {
		return "Hellor World! Time on Server is :" + LocalDateTime.now();
	}
	
	@GetMapping("/workout")
	public String daylyworkout() {
		return "run 5k";
	}
	

	@GetMapping("/fortune")
	public String daylyfortune() {
		return "Today is your lucky day";
	}
}

package com.luv2code.aopdemo.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

@Component
public class TrafficFortuneService {
	public String getFortunee() {
		try {
			TimeUnit.SECONDS.sleep(5);
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
		return "Expect heavy traffic this morning";
	}
	public String getFortunee(boolean tripWire) {
		
		if(tripWire) {
			throw new RuntimeException("Accident High wa y clsoed");
		}
		return getFortunee();
	}
}

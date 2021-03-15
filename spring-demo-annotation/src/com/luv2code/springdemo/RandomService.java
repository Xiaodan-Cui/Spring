package com.luv2code.springdemo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomService implements FortuneService {

	
	//crreae an aray of strings
	
	private String[] data= {
			"hahaha",
			"lsllsdlfs",
			"fdsrewqr2"
	};
	
	private Random myRandom=new Random();
	
	
	@Override
	public String getFortune() {
		int index=myRandom.nextInt(data.length);
		return data[index];
	}

}

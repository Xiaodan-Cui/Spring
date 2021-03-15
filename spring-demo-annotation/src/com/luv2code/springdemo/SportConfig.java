package com.luv2code.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@ComponentScan("com.luv2code.springdemo")
@PropertySource("classpath:sport.properties")
public class SportConfig {
	//DEFINE BEAN  for sadfortune service
	@Bean
	public FortuneService sadFortuneService() {
		return new SadFortuneService();
	}
	//defin bean for our swimcoach and inject dependene
	@Bean
	public Coach swimCoach() {
		return new SwimCoach(sadFortuneService());
	}
}



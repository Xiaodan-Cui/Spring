package com.luv2code.jackson.jason.demo;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver {
	public static void main(String[] args) {
		try {
			ObjectMapper mapper=new ObjectMapper();
			
			Student s=mapper.readValue(new File("data/sample-full.json"), Student.class);
			
			System.out.println(s.getFirstName());
			System.out.println(s.getLastName());
			
			
			Address a=s.getAddress();
			
			System.out.println(a.getCity());
			
			for(String ss:s.getLanguages()) {
				System.out.println(ss);
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}

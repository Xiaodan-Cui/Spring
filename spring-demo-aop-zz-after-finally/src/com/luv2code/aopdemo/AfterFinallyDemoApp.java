package com.luv2code.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;


public class AfterFinallyDemoApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context=
				new AnnotationConfigApplicationContext(DemoConfig.class);
		AccountDAO theAccountDAO=context.getBean("accountDAO", AccountDAO.class);
		List<Account> acs=null;
				
		try {
			boolean tripwire=false;
			acs=theAccountDAO.findAccounts(tripwire);
		}
		catch(Exception exc) {
			System.out.println("\n\n Mai Program .. Caught Exc"+exc);
		}
		
		
		System.out.println(acs);

		context.close();
	}

}

package com.luv2code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context=
				new AnnotationConfigApplicationContext(DemoConfig.class);
		AccountDAO theAccountDAO=context.getBean("accountDAO", AccountDAO.class);
		Account ac=new Account();
		theAccountDAO.addAccount(ac,true);
		theAccountDAO.doWork();
		
		MembershipDAO theMembershipDAO=context.getBean("membershipDAO", MembershipDAO.class);
		
		System.out.println("\n do again");
		
		theMembershipDAO.addSillyMember();
		context.close();
	}

}

package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Component
public class AccountDAO {
	public void addAccount(Account account,boolean flag) {
		System.out.println(getClass()+"DO DB Work :add an account");
	}
	public boolean doWork() {
		System.out.println("doworkkkkkk");
		return false;
	}
}

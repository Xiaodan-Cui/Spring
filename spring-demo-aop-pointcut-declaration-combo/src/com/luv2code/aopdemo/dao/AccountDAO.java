package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Component
public class AccountDAO {
	private String name;
	private String serviceCode;
	public String getName() {
		System.out.println(getClass()+"getName");
		return name;
	}
	public void setName(String name) {
		System.out.println(getClass()+"setName");
		this.name = name;
	}
	public String getServiceCode() {
		System.out.println(getClass()+"getSC");
		return serviceCode;
	}
	public void setServiceCode(String serviceCode) {
		System.out.println(getClass()+"setSC");
		this.serviceCode = serviceCode;
	}
	public void addAccount(Account account,boolean flag) {
		System.out.println(getClass()+"DO DB Work :add an account");
	}
	public boolean doWork() {
		System.out.println("doworkkkkkk");
		return false;
	}
	
}

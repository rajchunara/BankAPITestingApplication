package com.model;

public class Customer {
	
	private String email;
	
	private long phoneNumber;
	
	private double balance;
	
	private long accountNumber;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Customer(String email, int phoneNumber, double balance, long accountNumber) {
		super();
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.balance = balance;
		this.accountNumber = accountNumber;
	}

	@Override
	public String toString() {
		return "Customer [email=" + email + ", phoneNumber=" + phoneNumber + ", balance=" + balance + ", accountNumber="
				+ accountNumber + "]";
	}
	
	

}

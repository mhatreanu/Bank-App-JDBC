package com.capgemini.bankapp.model;

public class BankAccount {

	private long accountId;
	private String accountHolder;
	private String accountType;
	private double accountBalance;
	
	public BankAccount() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public BankAccount(String accountHolder, String accountType, double accountBalance) {
		super();
		this.accountHolder = accountHolder;
		this.accountType = accountType;
		this.accountBalance = accountBalance;
	}

	
	public BankAccount(long accountId, String accountHolder, String accountType, double accountBalance) {
		super();
		this.accountId = accountId;
		this.accountHolder = accountHolder;
		this.accountType = accountType;
		this.accountBalance = accountBalance;
	}

	public long getAccountId() {
		return accountId;
	}

	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}

	public String getAccountHolder() {
		return accountHolder;
	}

	public void setAccountHolder(String accountHolder) {
		this.accountHolder = accountHolder;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	@Override
	public String toString() {
		return "BankAccount [accountId=" + accountId + ", accountHolder=" + accountHolder + ", accountType="
				+ accountType + ", accountBalance=" + accountBalance + "]";
	}

	
}

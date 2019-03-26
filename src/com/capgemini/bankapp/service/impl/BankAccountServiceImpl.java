package com.capgemini.bankapp.service.impl;

import java.util.List;

import com.capgemini.bankapp.dao.BankAccountDao;
import com.capgemini.bankapp.dao.impl.BankAccountDaoimpl;
import com.capgemini.bankapp.exception.LowBalanceException;
import com.capgemini.bankapp.model.BankAccount;
import com.capgemini.bankapp.service.BankAccountService;

public class BankAccountServiceImpl implements BankAccountService{
	
	private BankAccountDao bankAccountDao;
	
	public BankAccountServiceImpl() {
		bankAccountDao=new BankAccountDaoimpl();
	}

	@Override
	public double checkBalance(long accountId) {
		return bankAccountDao.getBalance(accountId);
	}

	@Override
	public double withdraw(long accountId, double amount) throws LowBalanceException {
		
		double balance=bankAccountDao.getBalance(accountId);
		if(balance-amount>0)
		{
			balance=balance-amount;
			bankAccountDao.updateBalance(accountId, balance);
			return balance;
		}
		
		else throw new LowBalanceException("No Sufficient Balance");
	}

	@Override
	public double deposite(long accountId, double amount) {
		
		double balance=bankAccountDao.getBalance(accountId);
		balance=balance+amount;
		bankAccountDao.updateBalance(accountId, balance);
		return balance;
	}

	@Override
	public boolean deleteBankAccount(long accountId) {
		
		return bankAccountDao.deleteBankAccount(accountId);
	}

	@Override
	public double fundTransfer(long fromAccountId, long toAccountId, double amount) throws LowBalanceException {
		
		double newBalance=withdraw(fromAccountId,amount);
		deposite(toAccountId,amount);
		return newBalance;
	}

	@Override
	public boolean addNewBankAccount(BankAccount account) {
		
		return bankAccountDao.addNewBankAccount(account);
	}

	@Override
	public List<BankAccount> findAllBankAccounts() {
		
		return bankAccountDao.findAllBankAccounts();
	}

	@Override
	public List<BankAccount> findBankAccountOfGivenId(long accountId) {
	
		return bankAccountDao.findBankAccountOfGivenId(accountId);
	}

}

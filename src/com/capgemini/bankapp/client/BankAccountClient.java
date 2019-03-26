package com.capgemini.bankapp.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.capgemini.bankapp.exception.LowBalanceException;
import com.capgemini.bankapp.model.BankAccount;
import com.capgemini.bankapp.service.BankAccountService;
import com.capgemini.bankapp.service.impl.BankAccountServiceImpl;

public class BankAccountClient {

	public static void main(String[] args) throws LowBalanceException {

		int choice;
		String accountHolder;
		String accountType;
		double accountBalance;
		BankAccountService bankService = new BankAccountServiceImpl();

		try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
			while (true) {
				System.out.println(
						"1. Add New Bank Account\n 2. Withdraw Amount\n 3. Deposite Amount\n 4. Fund Transfer\n 5. Delete Bank Account\n 6. Display All Bank Account Details\n "
						+ "7. Search Bank Account\n 8. Check Balance");

				System.out.println("Enter your choice");
				choice = Integer.parseInt(reader.readLine());

				switch (choice) {

				case 1:
					System.out.println("Enter Account Holder Name");
					accountHolder = reader.readLine();

					System.out.println("Enter Account Type");
					accountType = reader.readLine();

					System.out.println("Enter Account Balance");
					accountBalance = Double.parseDouble(reader.readLine());

					BankAccount account = new BankAccount(accountHolder, accountType, accountBalance);
					if (bankService.addNewBankAccount(account))
						System.out.println("Account created successfully...\n");
					else
						System.out.println("failed to create new account...\n");
					break;

				case 2:
					System.out.println("Enter Account ID");
					long accountId = Long.parseLong(reader.readLine());

					System.out.println("Enter amount");
					double amount = Double.parseDouble(reader.readLine());

					System.out.println(bankService.withdraw(accountId, amount));
					break;

				case 3:
					System.out.println("Enter Account ID");
					long accountID = Long.parseLong(reader.readLine());

					System.out.println("Enter Amount");
					amount = Double.parseDouble(reader.readLine());

					System.out.println(bankService.deposite(accountID, amount));
					break;

				case 4:
					System.out.println("Enter From Account ID");
					long fromAccountId = Long.parseLong(reader.readLine());

					System.out.println("Enter To Account ID");
					long toAccountId = Long.parseLong(reader.readLine());

					System.out.println("Enter Amount");
					amount = Double.parseDouble(reader.readLine());

					System.out.println(bankService.fundTransfer(fromAccountId, toAccountId, amount));
					break;

				case 5:
					System.out.println("Enter Account ID");
					accountId = Long.parseLong(reader.readLine());
					System.out.println(bankService.deleteBankAccount(accountId));
					break;
					
				case 6:
					System.out.println(bankService.findAllBankAccounts());
					break;
					
				case 7:
					System.out.println("Enter Account ID");
					accountID = Long.parseLong(reader.readLine());
					
					System.out.println(bankService.findBankAccountOfGivenId(accountID));
					break;
					
				case 8:
					System.out.println("Enter Account ID");
					accountId = Long.parseLong(reader.readLine());
					
					System.out.println(bankService.checkBalance(accountId));
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

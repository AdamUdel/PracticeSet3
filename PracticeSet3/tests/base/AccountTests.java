package base;

import static org.junit.Assert.*;
import org.junit.Test;

public class AccountTests {

	//These variables are what to expect from an Account made from the default constructor.
	int defaultID = 0;
	double defaultBalance = 0;
	double defaultRate = 0;
	//First test object (from default constructor)
	Account defaultAccount = new Account();
	
	//Attributes for the second test Object.
	int ID = 1122;
	double balance = 20000.0;
	double annualrate = 0.045;
	//Test second test object.
	Account testAccount = new Account(ID, balance, annualrate);
	
	//Test Values
	double withdrawAmount = 2500.00;
	double depositAmount = 3000.00;
	
	
	@Test
	public void testDefaultConstructor(){
		//Tests to make sure that the default Annual Interest Rate is 0.
		assert(defaultAccount.getAnnualInterestRate() == defaultRate);
		//Tests to make sure that the default Balance is 0.
		assert(defaultAccount.getBalance() == defaultBalance);
		//Tests to make sure that the default ID is 0.
		assert(defaultAccount.getID() == defaultID);
	}
	
	
	@Test
	public void testWithdrawMethod() throws InsufficientFundsException{
		double initialBalance = testAccount.getBalance();
		testAccount.withdraw(withdrawAmount);
		double newBalance = testAccount.getBalance();
		assert(initialBalance-newBalance == withdrawAmount);
		//This tests whether the balance decreased by 2500 after this method was called
		
	}
	
	@Test
	public void testDepositMethod(){
		double initialBalance = testAccount.getBalance();
		testAccount.deposit(depositAmount);
		double newBalance = testAccount.getBalance();
		assert(newBalance-initialBalance == depositAmount);
		//This tests whether the balance increased by 3000 after this method was called
	}
	
	@Test
	public void testPrintMethods(){
		//What is actually recieved from the method
		String phrase = testAccount.printAccount();
		//Sets a sentence based off of what to expect
		String sentence = "The account was created on "
							+(testAccount.getDateCreated().getMonth()+1)+"-"
							+testAccount.getDateCreated().getDay()+"-"
							+(testAccount.getDateCreated().getMonth()+1900)
							+'\n'
							+"Balance: "+testAccount.getBalance()
							+'\n'
							+"Interest Rate: "+testAccount.getAnnualInterestRate();
		
		assert(phrase == sentence);
		//Also prints the data, balance, and rate
		System.out.println(phrase);
	}
	
} 

package base;

import java.util.Date;

public class Account {
	
	private int ID;
	private double balance;
	private double annualInterestRate;
	private Date dateCreated = new Date();
	
	
	
	public Account(){
		this.ID = 0;
		this.balance = 0;
		this.annualInterestRate = 0;
	}
	
	public Account(int identity, double userBalance, double yearlyInterestRate){
		ID = identity;
		balance = userBalance;
		annualInterestRate = yearlyInterestRate;
	}

	
	
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getAnnualInterestRate() {
		return annualInterestRate;
	}

	public void setAnnualInterestRate(double annualInterestRate) {
		this.annualInterestRate = annualInterestRate;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public double getMonthlyInterestRate(){
		double monthlyInterestRate = annualInterestRate/12.0;
		return(monthlyInterestRate);
	}
	
	public void withdraw(double amount) throws InsufficientFundsException{
		if (amount <= balance) {
			balance = balance - amount;
		} 
		else {
			throw (new InsufficientFundsException());
		} 
		
	}
	
	public void deposit(double amount){
		balance = balance+amount;
	}
	
	public String printAccount(){
		int month = dateCreated.getMonth();
		int day = dateCreated.getDay();
		int yearsSince1900 = dateCreated.getYear();
		int year = yearsSince1900+1900;
		month+=1; 
		//In the Date class, month counts from 0-11
		//This sets month to be from 1-12
		
		String sentence = "The account was created on "+month+"-"+day+"-"+year+'\n'
							+"Balance: "+this.getBalance()+'\n'
							+"Interest Rate: "+this.getAnnualInterestRate();
		
		return(sentence);
		
	}
}

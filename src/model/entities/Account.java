package model.entities;

import model.exception.DomianException;

public class Account {

	private Integer number;
	private String holder;
	private double balance;
	private double withdrawlimit;
	
	public Account() {}

	public Account(Integer number, String holder, double balance, double withdrawlimit) {
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrawlimit = withdrawlimit;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getWithdrawlimit() {
		return withdrawlimit;
	}

	public void setWithdrawlimit(double withdrawlimit) {
		this.withdrawlimit = withdrawlimit;
	}
	
	public void deposit(double amount) {
		this.balance += amount;
	}
	
	public void withdraw(double amount) {
		if (amount > withdrawlimit) {
			throw new DomianException("The amount exceeds withdraw limit");
		}
		else if (amount > balance) {
			throw new DomianException("Not enough balance");
		}
		else {
			this.balance -= amount;
		}
	}
}

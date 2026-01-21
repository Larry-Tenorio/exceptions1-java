package model.entities;

import model.exceptions.DomainException;

public class Account {

	private Integer number;
	private String holder;
	private Double balance;
	private Double withDrawLimit;

	public Account() {

	}

	public Account(Integer number, String holder, Double balance, Double withDrawLimit) {
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withDrawLimit = withDrawLimit;
	}

	public Integer getNumber() {
		return number;
	}

	public String getHolder() {
		return holder;
	}


	public Double getBalance() {
		return balance;
	}

	public Double getWithDrawLimit() {
		return withDrawLimit;
	}

	public void deposit(Double amount) {
		if(amount <= 0) {
			throw new DomainException("Deposit amount must be positive");
		}
		balance += amount;
	}
	
	public void withDraw(Double amount) {
		if(amount > withDrawLimit) {
			throw new DomainException("the amount exceeds withdraw limit");
		}
		if(amount > balance) {
			throw new DomainException("Not enough balance");
		}
		balance -= amount;
	}
}

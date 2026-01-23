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

	public void deposit(double amount) {
		if (amount <= 0) {
			throw new DomainException("Withdraw amount must be positive");
		}
		balance += amount;
	}

	public void withDraw(double amount) {
		if (amount <= 0) {
            throw new DomainException("Withdraw amount must be positive");
        }
		if (amount > withDrawLimit) {
			throw new DomainException("Withdraw amount exceeds the account limit");
		}
		if (amount > balance) {
			throw new DomainException(
					"Withdraw amount exceeds current balance");
		}
		balance -= amount;
	}
}

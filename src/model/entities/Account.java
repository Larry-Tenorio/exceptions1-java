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
		if (amount < 0) {
			throw new DomainException("not is possible deposit value negative");
		}
		balance += amount;
	}

	public void withDraw(Double amount) {
		if (amount > withDrawLimit) {
			throw new DomainException("the whitdraw do not to be bigger withdraw limit");
		}
		if (amount > balance || balance <= 0) {
			throw new DomainException(
					"Cannot withdraw: amount exceeds balance or is invalid");
		}
		balance -= amount;
	}
}

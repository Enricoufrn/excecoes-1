package model.entities;

import model.exception.DomainException;

public class Account {
	private Integer number;
	private String holder;
	private Double balance,withDrawLimit;

	public Account() {

	}

	public Account(Integer number, String holder, Double balance, Double withdraw) {
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withDrawLimit = withdraw;
	}

	public Account(Integer number,String holder) {
		this.number = number;
		this.holder = holder;
		// balance = 0.0; por padrão java inicializa atributos numericos como 0
		withDrawLimit = 300.0;
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

	public Double getWithdraw() {
		return withDrawLimit;
	}
	
	public Double getBalance() {
		return balance;
	}

	public void setWithdraw(Double withdraw) {
		this.withDrawLimit = withdraw;
	}
	
	public void deposit(Double amount) {
		this.balance+=amount;
	}
	
	public void withdraw(Double amount) throws DomainException{
		if(!(balance > 0.0) || amount > balance) {
			throw new DomainException("Not enough balance");
		}
		if(amount > withDrawLimit) {
			throw new DomainException("The amount exceeds withdraw limit");
		}
		balance-=amount;
	}
}

package com.bankapp.beans;

public class DepositBean {

	private int depositId;
	private double amount;
	public DepositBean() {
	}
	public DepositBean(int depositId, double amount) {
		this.depositId = depositId;
		this.amount = amount;
	}
	public int getDepositId() {
		return depositId;
	}
	public void setDepositId(int depositId) {
		this.depositId = depositId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
}

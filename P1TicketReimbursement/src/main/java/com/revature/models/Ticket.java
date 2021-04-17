package com.revature.models;

import java.sql.Timestamp;

public class Ticket {
	
	enum TYPE{
		LODGING, TRAVEL, FOOD, OTHER
	}
	
	private TYPE type;
	private double amount;
	private boolean approval;
	private int employeeID;
	private long stamp;
	static Timestamp ts;
	
	public Ticket(TYPE type, double amount, boolean approval, int employeeID) {
		this.type = type;
		this.setAmount(amount);
		this.setApproval(approval);
		this.employeeID = employeeID;
		stamp = ts.getTime();
	}

	public long getStamp() {
		return stamp;
	}

	public int getEmployeeID() {
		return employeeID;
	}

	public boolean getApproval() {
		return approval;
	}

	public void setApproval(boolean approval) {
		this.approval = approval;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public TYPE getType() {
		return type;
	}

}

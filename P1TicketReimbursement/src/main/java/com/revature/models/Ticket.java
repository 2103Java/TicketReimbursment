package com.revature.models;

import java.sql.Timestamp;

public class Ticket {
	
	enum TYPE{
		LODGING, TRAVEL, FOOD, OTHER
	}
	
	enum APPROVAL{
		REJECTED, PENDING, APPROVED
	}
	
	private TYPE type;
	private double amount;
	private APPROVAL approval;
	private int employeeID;
	private long stamp;
	static Timestamp ts;
	
	public Ticket(TYPE type, double amount, APPROVAL approval, int employeeID) {
		this.type = type;
		this.amount = amount;
		this.approval= approval;
		this.employeeID = employeeID;
		stamp = ts.getTime();
	}

	public long getStamp() {
		return stamp;
	}

	public int getEmployeeID() {
		return employeeID;
	}

	public APPROVAL getApproval() {
		return approval;
	}

	public void setApproval(APPROVAL approval) {
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

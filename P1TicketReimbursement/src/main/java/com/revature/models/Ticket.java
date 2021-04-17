package com.revature.models;

import java.sql.Timestamp;
import java.util.Date;

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
	private String stamp;
	
	public Ticket(TYPE type, double amount, APPROVAL approval, int employeeID) {
		this.type = type;
		this.amount = amount;
		this.approval= approval;
		this.employeeID = employeeID;
		Date date = new Date();
		Timestamp ts = new Timestamp(date.getTime());
		stamp = ts.toString().substring(0,19);
	}

	public String getStamp() {
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

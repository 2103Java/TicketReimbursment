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
	private long stamp;
	static Timestamp ts;
	private int ticketID;
	
	
	public Ticket(TYPE type, double amount, APPROVAL approval, int employeeID, int ticketID) {
		this.type = type;
		this.setAmount(amount);
		this.setApproval(approval);
		this.employeeID = employeeID;
		this.ticketID = ticketID;
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

	public void setApproval(APPROVAL approval2) {
		this.approval = approval2;
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

	public int getTicketID() {
		return ticketID;
	}

	public void setTicketID(int ticketID) {
		this.ticketID = ticketID;
	}

}

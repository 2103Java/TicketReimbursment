package com.revature.models;

import java.sql.Timestamp;
import java.util.Date;

public class Ticket {
	
	public enum TYPE{
		LODGING, TRAVEL, FOOD, OTHER
	}
	public enum APPROVAL{
		REJECTED, PENDING, APPROVED
	}
	
	
	private TYPE type;
	private double amount;
	private APPROVAL approval;
	private int employeeID;
	private String stamp;
	private int ticketID;
	
	Timestamp ts;
	
	
	

	public Ticket() {
		super();
		Date date = new Date();
		Timestamp ts = new Timestamp(date.getTime());
		stamp = ts.toString().substring(0,19);
		this.ticketID = 0;
	}

	@Override
	public String toString() {
		return "Ticket [type=" + type + ", amount=" + amount + ", approval=" + approval + ", employeeID=" + employeeID
				+ ", stamp=" + stamp + ", ticketID=" + ticketID + "]";
	}

	public Ticket(TYPE type, double amount, APPROVAL approval, String stamp, int employeeID, int ticketID) {
		this.type = type;
		this.amount = amount;
		this.approval= approval;
		this.employeeID = employeeID;
		this.stamp = stamp;
		this.ticketID = ticketID;
		ts = new Timestamp(System.currentTimeMillis());
	}

	public Ticket(TYPE type, double amount, APPROVAL approval, int employeeID, int ticketID) {
		this.type = type;
		this.amount = amount;
		this.approval= approval;
		this.employeeID = employeeID;
		this.ticketID = ticketID;
		
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
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
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

	public int getTicketID() {
		return ticketID;
	}

	public void setTicketID(int ticketID) {
		this.ticketID = ticketID;
	}

}

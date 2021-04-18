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
	
	


	Timestamp ts;
	private int ticketID;
	
	
	public Ticket(TYPE type, double amount, APPROVAL approval, int employeeID, int ticketID) {

		this.type = type;
		this.amount = amount;
		this.approval= approval;
		this.employeeID = employeeID;

		Date date = new Date();
		Timestamp ts = new Timestamp(date.getTime());
		stamp = ts.toString().substring(0,19);

		this.ticketID = ticketID;
		

	}


	public Ticket(TYPE type, double amount, APPROVAL approval, String stamp, int employeeID, int ticketID) {
		this.type = type;
		this.amount = amount;
		this.approval= approval;
		this.employeeID = employeeID;
		this.stamp = stamp;
		this.ticketID = ticketID;
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

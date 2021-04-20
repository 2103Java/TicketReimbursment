package com.revature.models;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
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
	
	
	
	private static final SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	Timestamp ts;
	private int ticketID;
	
	
	



	public Ticket(TYPE type, double amount, APPROVAL approval, String stamp, int employeeID, int ticketID) {
		this.type = type;
		this.amount = amount;
		this.approval= approval;
		this.employeeID = employeeID;
		this.stamp = stamp;
		this.ticketID = ticketID;
		ts = new Timestamp(System.currentTimeMillis());
	}

	public String getStamp() {
		return stamp;

	}
	public String getTime()
	{
		return date.format(ts);
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

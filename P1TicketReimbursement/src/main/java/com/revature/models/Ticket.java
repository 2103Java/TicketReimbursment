package com.revature.models;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import ENUMS.ENUM;

@Entity
@Table(name = "tickets")
@TypeDef(name = "approval",
typeClass = ENUM.class)
@TypeDef(name = "type",
typeClass = ENUM.class)
public class Ticket {
	
	public enum TYPE{
		LODGING, TRAVEL, FOOD, OTHER
	}
	public enum APPROVAL{
		REJECTED, PENDING, APPROVED
	}
	
	@Column(name = "type")
	@Enumerated(EnumType.STRING)
	private TYPE type;
	
	@Column(name = "amount")
	private double amount;
	
	@Column(name = "approval")
	@Enumerated(EnumType.STRING)
	private APPROVAL approval;
	
	@Column(name = "fk_employee_id")
	@JoinColumn(name = "employee_id")
	private int employeeID;
	
	@Column(name = "time")
	private String stamp;
	
	@Id
	@Column(name = "ticket_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int ticketID;
	
	Timestamp ts;
	
	
	



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

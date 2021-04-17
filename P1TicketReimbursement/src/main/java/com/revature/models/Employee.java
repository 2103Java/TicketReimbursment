package com.revature.models;

import java.util.ArrayList;
import java.util.List;

public class Employee {
	
	private int employeeID;
	private String firstName;
	private String username;
	private String pass;
	private List<Ticket> myTickets = new ArrayList<Ticket>();
	
	public Employee(int employeeID, String firstName, String username, String pass) {
		this.employeeID = employeeID;
		this.firstName = firstName;
		this.username = username;
		this.setPass(pass);
	}

	public List<Ticket> getMyTickets() {
		return myTickets;
	}

	public void setMyTickets(List<Ticket> myTickets) {
		this.myTickets = myTickets;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getUsername() {
		return username;
	}

	public String getFirstName() {
		return firstName;
	}

	public int getEmployeeID() {
		return employeeID;
	}
	
	

}

package com.revature.models;

import java.util.ArrayList;
import java.util.List;

public class Employee {
	
	private int employeeID;
	private String firstName;
	private String username;
	private String pass;
	private CATEGORY employment;
	private List<Ticket> myTickets = new ArrayList<Ticket>();
	
	public enum CATEGORY{
		EMPLOYEE, FINANCEADMIN
	}
	
	public Employee(int employeeID, String firstName, String username, String pass) {
		this.employeeID = employeeID;
		this.firstName = firstName;
		this.username = username;
		this.pass = pass;
		employment = CATEGORY.EMPLOYEE;
	}

	public Employee(String username, String pass, CATEGORY employment, int employeeID) {
		this.username = username;
		this.pass = pass;
		this.employment = employment;
		this.employeeID = employeeID;
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
	
	public void setEmploymentStatus(CATEGORY type) {
		this.employment = type;
	}
	public CATEGORY getEmployment() {
		return this.employment;
	}
	
	

}

package com.revature.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import ENUMS.ENUM;

@Entity
@Table(name = "employees")
@TypeDef(name = "category",
typeClass = ENUM.class)



public class Employee {
	
	@Id
	@Column(name = "employee_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int employeeID;
	
	
	@Column(name = "first_name")
	private String firstName;
	
	
	@Column(name = "user_name", unique = true, nullable = false)
	
	private String username;
	
	
	@Column(name = "password")
	private String pass;
	
	
	@Column(name = "category")
	@Enumerated(EnumType.STRING)
	private CATEGORY employment;
	
	
	@Column(name = "tickets")
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
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

	public Employee() {
		super();
		
	}

	@Override
	public String toString() {
		return "Employee [employeeID=" + employeeID + ", username=" + username + ", employment=" + employment + "]";
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

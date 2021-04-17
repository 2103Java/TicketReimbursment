package com.revature.models;

import java.util.ArrayList;
import java.util.List;

public class FinanceManager extends Employee{
	List<Ticket> tickets = new ArrayList<Ticket>();
	
	public FinanceManager(int employeeID, String firstName, String username, String pass) {
		super(employeeID, firstName, username, pass);
		super.setEmploymentStatus(CATEGORY.FINANCEMANAGER);
	}

	

}

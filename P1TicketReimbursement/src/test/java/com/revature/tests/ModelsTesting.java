package com.revature.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.revature.models.*;
import com.revature.models.Employee.CATEGORY;
import com.revature.models.Ticket.APPROVAL;
import com.revature.models.Ticket.TYPE;
import com.revature.servlet.MasterServlet;


public class ModelsTesting {
	
	@Test
	public void singleTicketTest() {
		Ticket t1 = new Ticket(TYPE.LODGING, 200.00, APPROVAL.PENDING, 1, 10101);
		
		if(t1.getType() == null) fail("failed to properly initialize a ticket object");
		
		MasterServlet.loggy.info(t1.getStamp());
		
		assertEquals(10101, t1.getTicketID());
		assertEquals(1, t1.getEmployeeID());
		assertTrue(TYPE.LODGING == t1.getType());
	}
	
	@Test
	public void verfiyTktTimeStamps() {
		Ticket t1 = new Ticket(TYPE.LODGING, 200.00, APPROVAL.PENDING, 1, 10101);
		try {
			Thread.currentThread();
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Ticket t2 = new Ticket(TYPE.TRAVEL, 300.00, APPROVAL.PENDING, 1, 10101);
		
		
		assertTrue(t1.getStamp().compareTo(t2.getStamp()) != 0);
		assertTrue(t1.getStamp().length() == 19 && t2.getStamp().length() == 19);
	}

	@Test 
	public void verifyTktEnums() {
		Ticket t1 = new Ticket(TYPE.LODGING, 200.00, APPROVAL.PENDING, 1, 10101);
		Ticket t2 = new Ticket(TYPE.TRAVEL, 200.00, APPROVAL.REJECTED, 1, 10103);
		Ticket t3 = new Ticket(TYPE.FOOD, 200.00, APPROVAL.APPROVED, 1, 10105);
		
		if(t1.getType() == t2.getType()) fail("Ticket Type is not unqiue");
		if(t1.getApproval() == t3.getApproval())fail("Ticket approval is not unique");
	}
	
	@Test
	public void verifyEmployeeFinanceEnums() {
		Employee e = new Employee("employee1","password", CATEGORY.EMPLOYEE, 2);
		FinanceManager fa = new FinanceManager(1, "Dan", "admin", "password");
		
		if(fa.getEmployment() == e.getEmployment()) fail("Employment status is not unique");
		
	}
}


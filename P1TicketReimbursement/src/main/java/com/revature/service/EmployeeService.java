package com.revature.service;

import java.sql.Connection;

import com.revature.connection.Connector;
import com.revature.dao.EmployeeDaoImpl;
import com.revature.dao.TicketDaoImpl;
import com.revature.models.Employee;
import com.revature.models.Ticket;

public class EmployeeService {
	private EmployeeDaoImpl eDao;
	private static Connection conn;

	public EmployeeService(EmployeeDaoImpl eDao) {
		// TODO Auto-generated constructor stub
		this.eDao = eDao;
		conn = Connector.setUpConnection(); // WHEN THIS CLASS IS INSTANATIATED AT THE HELPER A CONNECTION IS MADE HERE
	}




	public Employee getEmployee(int id) { //NOT SUPER SURE WHAT THE POINT OF THIS LAYER IS, AT THIS POINT WE ALREADY HAVE A TICKET OBJECT
	
	// TODO Auto-generated method stub
	
	Employee e = null;
	e = eDao.retrieveTicketByID(id,conn); 
	
	return e;
	}

}
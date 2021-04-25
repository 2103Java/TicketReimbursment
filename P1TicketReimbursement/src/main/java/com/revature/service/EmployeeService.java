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
	e = eDao.findEmployeeByID(id,conn); 
	
	return e;
	}
	
	public boolean putEmployee(Employee e) {
		
		Employee check = eDao.findEmployee(e, conn);
		
		if (check != null) {
			//eDao.updatePassword(check, conn);
			return false; //in this case we are trying to create a user who already exists or? Not sure why we should update
		}
		
		else eDao.insertNewEmployee(e, conn);
		
		return true;
	}

	public boolean deleteEmployee(int id) {
		Employee e = eDao.findEmployeeByID(id, conn);
		
		if(e == null) return false;
		
		else eDao.deleteEmployee(e, conn);
		return true;
	}




	public Employee postEmployee(Employee tmp) {
		System.out.print("INSIDE EMPLOYEE POST");
		Employee e = eDao.findEmployee(tmp, conn);
		if(e == null) {
			System.out.println("EMPLOYEE DNE");
			return null;
		}
		
		System.out.println("Employee Found!!");
		return e;
	}




	
}
package com.revature.dao;

import java.sql.Connection;

import com.revature.models.Employee;

public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public boolean insertNewEmployee(Employee E, Connection conn) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Employee findEmployee(Employee E, Connection conn) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updatePassword(Employee E, Connection conn) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updatePersonalInfo(Employee E, Connection conn) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteEmployee(Employee E, Connection conn) {
		// TODO Auto-generated method stub
		return false;
	}

	public Employee retrieveTicketByID(int id, Connection conn) {
		// TODO Auto-generated method stub
		return null;
	}

}

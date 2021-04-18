package com.revature.dao;

import java.sql.Connection;

import com.revature.models.Employee;

public interface EmployeeDao {

	
	//CREATE
	public boolean insertNewEmployee(Employee E, Connection conn);
	
	//SELECT
	public Employee findEmployee(Employee E, Connection conn);
	public Employee findEmployeeByID(int id, Connection conn);
	public Employee findEmployeeByTicketID(int id, Connection conn);
	
	//UPDATE
	public boolean updatePassword(Employee E, Connection conn);
	public boolean updatePersonalInfo(Employee E, Connection conn);
	
	
	//DELETE
	public boolean deleteEmployee(Employee E, Connection conn);
	
}

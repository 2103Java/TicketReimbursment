package com.revature.tests;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import com.revature.connection.Connector;
import com.revature.dao.EmployeeDao;
import com.revature.dao.EmployeeDaoImpl;
import com.revature.models.Employee;
import com.revature.models.Employee.CATEGORY;

public class DAOTesting {
	static Connection conn;

	@Test
	public void connectionTest() throws SQLException {
		DAOTesting.conn = Connector.setUpConnection();

	}

	// @Test //Note user_id_seq updates in DB with every test, insert is working as
	// expected
	public void employeeDaoInsertTest() {
		DAOTesting.conn = Connector.setUpConnection();
		EmployeeDao ed = new EmployeeDaoImpl();

		Employee e = new Employee("employee1", "password", CATEGORY.EMPLOYEE, 1);
		Employee e2 = new Employee("employee2", "password", CATEGORY.EMPLOYEE, 1);
		Employee e3 = new Employee("employee3", "password", CATEGORY.EMPLOYEE, 1);

		ed.insertNewEmployee(e, conn);
		ed.insertNewEmployee(e2, conn);
		ed.insertNewEmployee(e3, conn);

		// Test will fail if sql exception is thrown

	}

	@Test
	public void employeeDaoFindTests() {
		EmployeeDao ed = new EmployeeDaoImpl();

		Employee e = ed.findEmployeeByID(7, conn);
		if (e.getUsername().compareTo("employee1") != 0)
			fail("Failed to find employee1 in DB by ID");

		// Employee e2 = ed.findEmployee(new
		// Employee("employee2","password",CATEGORY.EMPLOYEE,8),conn);
		// if(e2.getUsername().compareTo("employee2") != 0)fail("Failed to find empoyee2
		// in DB by Employee Object");

	}

	// @Test - Delete is working as expected
	public void employeeDaoDeleteTest() {
		EmployeeDao ed = new EmployeeDaoImpl();
		ed.deleteEmployee(new Employee("employee2", "password", CATEGORY.EMPLOYEE, 8), conn);
		// Test will fail if sql exception occurs
	}
}

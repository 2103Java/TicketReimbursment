package com.revature.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.revature.models.Employee;

public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public boolean insertNewEmployee(Employee E, Connection conn) {
		try {
			Statement stmnt = conn.createStatement();
			String sql = "INSERT INTO tktemployees values ('"+ E.getUsername()+"','"+E.getPass()+"','"+E.getEmployment()+"',nextval('tktemployees_user_id_seq'))";

			stmnt.executeUpdate(sql);
		} catch (SQLException e) {
			return false;
		}
		return true;
	}

	@Override
	public Employee findEmployee(Employee E, Connection conn) {
		Employee employee = null;
		try {
			Statement stmnt = conn.createStatement();
			String sql = "SELECT * from tktemployees where username = '" + E.getUsername() + "'";

			ResultSet rs = stmnt.executeQuery(sql);
			
			while(rs.next()) {
				String username = rs.getString("username");
				String pass = rs.getString("password");
				Employee.CATEGORY employment = Employee.CATEGORY.valueOf(rs.getString("type"));
				int user_id = rs.getInt("user_id");
				
				employee = new Employee(username, pass, employment, user_id);
			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return employee;
	}

	@Override
	public Employee findEmployeeByID(int id, Connection conn) {
		Employee employee = null;
		try {
			Statement stmnt = conn.createStatement();
			String sql = "SELECT * from tktemployees where user_id = " + id;

			ResultSet rs = stmnt.executeQuery(sql);
			
			while(rs.next()) {
				String username = rs.getString("username");
				String pass = rs.getString("password");
				Employee.CATEGORY employment = Employee.CATEGORY.valueOf(rs.getString("type"));
				int user_id = rs.getInt("user_id");
				
				employee = new Employee(username, pass, employment, user_id);
			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employee;
	}

	@Override
	public Employee findEmployeeByTicketID(int id, Connection conn) {
		Employee employee = null;
		try {
			Statement stmnt = conn.createStatement();
			String select = "(SELECT user_id from tickets where ticket_id = "+id+")";
			String sql = "SELECT * from tktemployees where user_id = " + select;

			ResultSet rs = stmnt.executeQuery(sql);
			
			while(rs.next()) {
				String username = rs.getString("username");
				String pass = rs.getString("password");
				Employee.CATEGORY employment = Employee.CATEGORY.valueOf(rs.getString("type"));
				int user_id = rs.getInt("user_id");
				
				employee = new Employee(username, pass, employment, user_id);
			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employee;
	}
	
	
	@Override
	public boolean updatePassword(Employee E, Connection conn) {
		// STRETCH GOAL
		return false;
	}

	@Override
	public boolean updatePersonalInfo(Employee E, Connection conn) {
		// STRETCH GOAL
		return false;
	}

	@Override
	public boolean deleteEmployee(Employee E, Connection conn) {
		try {
			Statement stmnt = conn.createStatement();
			String sql = "DELETE FROM tktemployees WHERE username = '" + E.getUsername() +"'";

			stmnt.executeUpdate(sql);
		} catch (SQLException e) {
			return false;
		}
		return true;
	}

	public Employee retrieveTicketByID(int id, Connection conn) {
		// TODO Auto-generated method stub
		return null;
	}

	

	

}

package com.revature.dao;

import java.sql.Connection;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.connection.HibernateConnection;
import static com.revature.connection.HibernateConnection.session;
import com.revature.models.Employee;
import com.revature.models.Ticket;

public class EmployeeHibernateDAO implements EmployeeDao {

	@Override
	public boolean insertNewEmployee(Employee E, Connection conn) {
		
		
		Transaction tx = session.beginTransaction();
		
		session.save(E);
		tx.commit();
		session.close();
		
		
		return true;
	}

	@Override
	public Employee findEmployee(Employee E, Connection conn) {
		
		System.out.println("Inside Hibernate Dao ");
		
		Employee e = session.get(Employee.class, E.getEmployeeID());
		
		return e;
	}

	@Override
	public Employee findEmployeeByID(int id, Connection conn) {
		System.out.println("Inside Hibernate Dao ");
		
		Employee e = session.get(Employee.class, id);
		
		return e;
	}

	@Override
	public Employee findEmployeeByTicketID(int id, Connection conn) {
		
		Ticket t = session.get(Ticket.class, id);
		
		Employee e = session.get(Employee.class, t.getEmployeeID());
		
		return e;
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

	@Override
	public Employee retrieveTicketByID(int id, Connection conn) {
		Ticket t = session.get(Ticket.class, id);
		
		Employee e = session.get(Employee.class, t.getEmployeeID());
		
		return e;
	}

}

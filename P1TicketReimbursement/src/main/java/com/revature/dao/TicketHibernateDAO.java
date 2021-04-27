package com.revature.dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Employee;
import com.revature.models.Ticket;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.revature.connection.HibernateConnection;
import static com.revature.connection.HibernateConnection.session;
import com.revature.models.Employee;
import com.revature.models.Ticket;
public class TicketHibernateDAO implements TicketDao {

	@Override
	public boolean insertNewTicket(Ticket t, Connection conn) {
		Transaction tx = session.beginTransaction();
		
		session.save(t);
		tx.commit();
		//session.close();
		
		
		return true;
	}

	@Override
	public List<Ticket> retrieveAllTickets(Connection conn) {
		// TODO Auto-generated method stu
		List<Ticket> l = new ArrayList<Ticket>();
		
		Criteria cr = session.createCriteria(Ticket.class);
		l = cr.list();
		
		return l;
	}

	@Override
	public List<Ticket> retrieveTicketByApproval(String approval, Connection conn) {
		List<Ticket> l = new ArrayList<Ticket>();
		
		Criteria cr = session.createCriteria(Ticket.class);
		cr.add(Restrictions.ilike(approval,"APPROVED"));
		l = cr.list();
		
		return l;
	}

	@Override
	public List<Ticket> retrieveTicketByEmployee(Employee E, Connection conn) {
		List<Ticket> l = new ArrayList<Ticket>();
		
		Criteria cr = session.createCriteria(Ticket.class);
		cr.add(Restrictions.like("fk_employee_id", E.getEmployeeID()));
		l = cr.list();
		
		return l;
	}

	@Override
	public List<Ticket> retrieveTicketByType(String type, Connection conn) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ticket retrieveTicketByID(int id, Connection conn) {
		Ticket t = session.get(Ticket.class, id);
		
		return t;
	}

	@Override
	public boolean approveTicket(Ticket t, Connection conn) {
		// TODO Auto-generated method stub
		
		Transaction tx = session.beginTransaction();
		session.merge(t);
		
		
		
		session.save(t);
		tx.commit();
		
		return true;
	}

	@Override
	public boolean rejectTicket(Ticket t, Connection conn) {
		Transaction tx = session.beginTransaction();
		session.merge(t);
		session.save(t);
		tx.commit();
		
		return true;
	}

	@Override
	public void updateTicket(Ticket t, Connection conn) {
		Transaction tx = session.beginTransaction();
		session.merge(t);
		session.save(t);
		tx.commit();
		
		

	}

	@Override
	public boolean deleteTicket(Ticket t, Connection conn) {
		// TODO Auto-generated method stub
		return false;
	}

}

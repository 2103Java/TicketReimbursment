package com.revature.dao;

import java.sql.Connection;
import java.util.List;

import com.revature.models.Employee;
import com.revature.models.Ticket;

public class TicketDaoImpl implements TicketDao {

	@Override
	public boolean insertNewTicket() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Ticket> retrieveAllTickets(Connection conn) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Ticket> retrieveTicketByApproval(boolean approval, Connection conn) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Ticket> retrieveTicketByEmployee(Employee E, Connection conn) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Ticket> retrieveTicketByType(String type, Connection conn) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean approveTicket(Ticket t, Connection conn) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean rejectTicket(Ticket t, Connection conn) {
		// TODO Auto-generated method stub
		return false;
	}

}

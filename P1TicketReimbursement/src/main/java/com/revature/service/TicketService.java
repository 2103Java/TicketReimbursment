package com.revature.service;

import java.sql.Connection;

import com.revature.connection.Connector;
import com.revature.dao.TicketDao;
import com.revature.dao.TicketDaoImpl;
import com.revature.models.Ticket;

public class TicketService {

	private TicketDaoImpl tDao;
	private static Connection conn;
	public TicketService(TicketDaoImpl tDao) {
		this.tDao = tDao;
		conn = Connector.setUpConnection(); // WHEN THIS CLASS IS INSTANATIATED AT THE HELPER A CONNECTION IS MADE HERE
	}

	public Ticket getTicket(int id) { //NOT SUPER SURE WHAT THE POINT OF THIS LAYER IS, AT THIS POINT WE ALREADY HAVE A TICKET OBJECT
		
		// TODO Auto-generated method stub
		
		Ticket t = null;
		t = tDao.retrieveTicketByID(id,conn); 
		
		return t;
	}

	public boolean postTicket(Ticket t) {
		// TODO Auto-generated method stub
		
		return false;
	}

	public boolean putTicket(Ticket t) {
		// TODO Auto-generated method stub
		return false;
	}

	public Ticket deleteTicket(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}

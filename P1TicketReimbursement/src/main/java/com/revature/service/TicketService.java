package com.revature.service;

import java.sql.Connection;

import com.revature.dao.TicketDao;
import com.revature.dao.TicketDaoImpl;
import com.revature.models.Ticket;

public class TicketService {

	private TicketDao tDao;
	private static Connection conn;
	public TicketService(TicketDao tDao) {
		this.tDao = tDao;
		conn = Connector.setUpConnection();
	}

	public Ticket getTicket(int id) {
		// TODO Auto-generated method stub
		
		Ticket t = null;
		t = tDao.retrieveTicketByID(id,conn);
		
		return t;
	}

}

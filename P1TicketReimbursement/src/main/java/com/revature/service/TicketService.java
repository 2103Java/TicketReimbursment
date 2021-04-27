package com.revature.service;

import java.sql.Connection;

import com.revature.connection.Connector;
import com.revature.dao.TicketDao;
import com.revature.dao.TicketDaoImpl;
import com.revature.dao.TicketHibernateDAO;
import com.revature.models.Ticket;

public class TicketService {

	private TicketHibernateDAO tDao;
	private static Connection conn;
	public TicketService(TicketHibernateDAO tDao) {
		this.tDao = tDao;
		conn = Connector.setUpConnection();
		//conn = Connector.setUpConnection(); // WHEN THIS CLASS IS INSTANATIATED AT THE HELPER A CONNECTION IS MADE HERE
		//System.out.println(conn + " is this connection null? because its not supposed to be");
	}

	public Ticket getTicket(int id) { //NOT SUPER SURE WHAT THE POINT OF THIS LAYER IS, AT THIS POINT WE ALREADY HAVE A TICKET OBJECT
									  //initially wanted this layer so we could verify server and DB access were working separately but we can put them together if you want
		
		// TODO Auto-generated method stub
		
		Ticket t = null;
		t = tDao.retrieveTicketByID(id,conn); 
		
		return t;
	}

	public boolean postTicket(Ticket t) {  //	I DONT THINK WE NEED THIS SINCE WE CAN JUST USE PUT FOR ALL OF OUR CREATION AND UPDATING OF TICKETS
											// + THAT WILL KEEP ALL OF OUR CREATION TO BE IDEMPOTENT 
		// TODO Auto-generated method stub
		
		return false;
	}

	public boolean putTicket(Ticket t) { //THIS METHOD WILL CHECK IF THE TICKET ALREADY EXISTS, IF IT DOES, UPDATE IT
											// IF THE TICKET DOESNT EXISTS IT WILL CREATE ONE IN THE DB
		// TODO Auto-generated method stub
		
		Ticket j = tDao.retrieveTicketByID(t.getTicketID(),conn);
		if(j != null )
		{
			//COMPARING T TICKET TO J TICKET TO FIND DIFFERENCE IN UPDATE, THEN PASS CORRECT TICKET DOWN TO DOA
			
			tDao.updateTicket(t, conn);
			return true;
		}
		else
		{
			tDao.insertNewTicket(t, conn);
			return true;
		}
	}

	public boolean deleteTicket(int id) {
		Ticket j = tDao.retrieveTicketByID(id,conn);
		
		if(j == null) return false; //we can add Ticket DNE message or log here?
		
		else tDao.deleteTicket(j, conn);
		
		
		return true;
	}

}

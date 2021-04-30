package com.revature.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.revature.connection.Connector;
import com.revature.dao.TicketDao;
import com.revature.dao.TicketDaoImpl;
import com.revature.models.Employee;
import com.revature.models.Ticket;
import com.revature.models.Ticket.APPROVAL;

public class TicketService {

	private TicketDaoImpl tDao;
	private static Connection conn;
	public TicketService(TicketDaoImpl tDao) {
		this.tDao = tDao;
		conn = Connector.setUpConnection();
		//conn = Connector.setUpConnection(); // WHEN THIS CLASS IS INSTANATIATED AT THE HELPER A CONNECTION IS MADE HERE
		//System.out.println(conn + " is this connection null? because its not supposed to be");
	}

	public List<Ticket> getTicket(int employeeID) { //NOT SUPER SURE WHAT THE POINT OF THIS LAYER IS, AT THIS POINT WE ALREADY HAVE A TICKET OBJECT
									  //initially wanted this layer so we could verify server and DB access were working separately but we can put them together if you want
		
		
		
		List<Ticket> t = new ArrayList<Ticket>();
		
		if(employeeID == -1) t = tDao.retrieveAllTickets(conn);
		
		else t = tDao.retrieveTicketByEmployee(employeeID, conn);
		
		return t;
	}

	public boolean postTicket(Ticket t) {  //	I DONT THINK WE NEED THIS SINCE WE CAN JUST USE PUT FOR ALL OF OUR CREATION AND UPDATING OF TICKETS
											// + THAT WILL KEEP ALL OF OUR CREATION TO BE IDEMPOTENT 
		Ticket tkt = tDao.retrieveTicketByID(t.getTicketID(), conn);
		
		if(t.getApproval() == APPROVAL.APPROVED) {
		tDao.approveTicket(tkt, conn);
		return true;
		}
		if(t.getApproval() == APPROVAL.REJECTED) {
			tDao.rejectTicket(tkt, conn);
			return true;
		}
		
		
		
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

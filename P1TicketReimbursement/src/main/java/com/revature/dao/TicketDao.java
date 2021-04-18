package com.revature.dao;

import java.sql.Connection;
import java.util.List;

import com.revature.models.Employee;
import com.revature.models.Ticket;

public interface TicketDao {
	
	//CREATE
	public boolean insertNewTicket(Ticket t, Connection conn);
	
	//SELECT
	public List<Ticket> retrieveAllTickets(Connection conn);
	public List<Ticket> retrieveTicketByApproval(String approval, Connection conn);
	public List<Ticket> retrieveTicketByEmployee(Employee E, Connection conn);
	public List<Ticket> retrieveTicketByType(String type, Connection conn);
	public Ticket retrieveTicketByID(int id, Connection conn); 
	
	//UPDATE
	public boolean approveTicket(Ticket t, Connection conn);
	public boolean rejectTicket(Ticket t, Connection conn);
	
	//DELETE
	

}

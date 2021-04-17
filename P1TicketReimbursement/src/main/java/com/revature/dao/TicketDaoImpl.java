package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

	@Override
	public Ticket retrieveTicketByID(int id, Connection conn) {
		// TODO Auto-generated method stub
		
		// TODO Auto-generated method stub
				String sql = "Select * from tickets where ticket_id = (?)";
				
				
				Ticket ticket = null;
				try{ 
					
					PreparedStatement ps = conn.prepareStatement(sql);
					
					ps.setInt(1,id);
					
					
					ResultSet rs = ps.executeQuery();
					
					
						
					while(rs.next())
					{
						
						
							ticket = new Ticket
								(
									null, 
									id, 
									null, 
									id, 
									id

								);
									
								
						}
					
						//System.out.println(user);
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("TicketFailed");
					
				}
				
	
				return ticket;
		
		
	}

}

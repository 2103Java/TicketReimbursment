package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.revature.models.Employee;
import com.revature.models.Ticket;
import com.revature.models.Ticket.APPROVAL;
import com.revature.models.Ticket.TYPE;

public class TicketDaoImpl implements TicketDao {


	@Override
	public boolean insertNewTicket(Ticket t, Connection conn) { //THIS NEEDS ACCESS TOCURRENT USER TO SET USERID WHEN CREATING NEW TICKETS
								//+ WE MIGHT HAVE TO SET UP SESSIONS JUST SO WE CAN KEEP TRACK OF CURRENT USER
		
		String sql = "insert into tickets VALUES (?),(?),(?),(?),(?)";
		
		
		
		try{ 
			
			PreparedStatement ps = conn.prepareStatement(sql);
			TYPE temp = t.getType();
			APPROVAL temp2 = t.getApproval();
			
			
			
			
			ps.setString(1,temp.toString());
			ps.setDouble(2, t.getAmount());
			ps.setString(3, temp2.toString());
			ps.setInt(4, t.getTicketID());
			ps.setTimestamp(0, t.getStamp());
			
			
			
			
			ps.execute();
			
			
				
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("UpdateTicketFailed");
			return false;
		}
	
		
		return true;
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
	public Ticket retrieveTicketByID(int id, Connection conn) {  // CONTACTING OUR SQL DATABASE AND SELECTING INFORMATION BASED ON TICKET_ID
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
						
						
							ticket = new Ticket // THIS NEEDS TO CREATE AN ACTUAL TICKET, FOR NOW THEY ARE ALL JUST NULL VALUES
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
				
	
				return ticket; // WE SHOULD BE ABLE TO GET THIS TICKET FROM POSTMAN NOW
		
		
	}

	
	@Override
	public void updateTicket(Ticket t, Connection conn) {
		// TODO Auto-generated method stub
		String sql = "Update tickets SET tkt_type = (?), amount = (?), approval = (?),  where ticket_id = (?)";
		
		
	
		try{ 
			
			PreparedStatement ps = conn.prepareStatement(sql);
			TYPE temp = t.getType();
			APPROVAL temp2 = t.getApproval();
			
			
			
			
			ps.setString(1,temp.toString());
			ps.setDouble(2, t.getAmount());
			ps.setString(3, temp2.toString());
			ps.setInt(4, t.getTicketID());
			
			
			
			ps.execute();
			
			
				
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("UpdateTicketFailed");
			
		}
	}

}

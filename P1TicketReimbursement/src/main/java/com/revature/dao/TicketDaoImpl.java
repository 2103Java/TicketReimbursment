package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Employee;
import com.revature.models.*;

public class TicketDaoImpl implements TicketDao {

	@Override
	public boolean insertNewTicket(Ticket t, Connection conn) {
		try {
			Statement stmnt = conn.createStatement();

			String sql = "INSERT INTO tickets VALUES ('" + t.getType() + "'," + t.getAmount() + ",'" + t.getApproval()
					+ "','" + t.getStamp() + "'" + t.getEmployeeID() + ",nextval('tkts_id_seq'))";
			
			stmnt.executeUpdate(sql);

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	@Override
	public List<Ticket> retrieveAllTickets(Connection conn) {
		List<Ticket> tickets = new ArrayList<Ticket>();
		try {
			Statement stmnt = conn.createStatement();

			String sql = "SELECT * from tickets";
			
			ResultSet rs = stmnt.executeQuery(sql);
			
			while(rs.next()) {
				Ticket.TYPE type = Ticket.TYPE.valueOf(rs.getString("tkttype"));
				double amount = rs.getDouble("amount");
				Ticket.APPROVAL approval = Ticket.APPROVAL.valueOf(rs.getString("approval"));
				String timeStamp = rs.getString("submission_date");
				int user_id = rs.getInt("user_id");
				int tkt_id = rs.getInt("ticket_id");
				
				Ticket t = new Ticket(type, amount, approval, timeStamp, user_id, tkt_id);
				tickets.add(t);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return tickets;
	}

	@Override
	public List<Ticket> retrieveTicketByApproval(String approval, Connection conn) {
		List<Ticket> tickets = new ArrayList<Ticket>();
		try {
			Statement stmnt = conn.createStatement();

			String sql = "SELECT * from tickets where approval = '" + approval.toUpperCase() +"'";
			
			ResultSet rs = stmnt.executeQuery(sql);
			
			while(rs.next()) {
				Ticket.TYPE type = Ticket.TYPE.valueOf(rs.getString("tkttype"));
				double amount = rs.getDouble("amount");
				Ticket.APPROVAL app = Ticket.APPROVAL.valueOf(rs.getString("approval"));
				String timeStamp = rs.getString("submission_date");
				int user_id = rs.getInt("user_id");
				int tkt_id = rs.getInt("ticket_id");
				
				Ticket t = new Ticket(type, amount, app, timeStamp, user_id, tkt_id);
				tickets.add(t);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return tickets;
	}

	@Override
	public List<Ticket> retrieveTicketByEmployee(Employee E, Connection conn) {
		List<Ticket> tickets = new ArrayList<Ticket>();
		try {
			Statement stmnt = conn.createStatement();

			String sql = "SELECT * from tickets where user_id = " + E.getEmployeeID();
			
			ResultSet rs = stmnt.executeQuery(sql);
			
			while(rs.next()) {
				Ticket.TYPE type = Ticket.TYPE.valueOf(rs.getString("tkttype"));
				double amount = rs.getDouble("amount");
				Ticket.APPROVAL approval = Ticket.APPROVAL.valueOf(rs.getString("approval"));
				String timeStamp = rs.getString("submission_date");
				int user_id = rs.getInt("user_id");
				int tkt_id = rs.getInt("ticket_id");
				
				Ticket t = new Ticket(type, amount, approval, timeStamp, user_id, tkt_id);
				tickets.add(t);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return tickets;
	}

	@Override
	public List<Ticket> retrieveTicketByType(String type, Connection conn) {
		List<Ticket> tickets = new ArrayList<Ticket>();
		try {
			Statement stmnt = conn.createStatement();

			String sql = "SELECT * from tickets WHERE tkttype = '" + type.toUpperCase()+"'";
			
			ResultSet rs = stmnt.executeQuery(sql);
			
			while(rs.next()) {
				Ticket.TYPE ty = Ticket.TYPE.valueOf(rs.getString("tkttype"));
				double amount = rs.getDouble("amount");
				Ticket.APPROVAL approval = Ticket.APPROVAL.valueOf(rs.getString("approval"));
				String timeStamp = rs.getString("submission_date");
				int user_id = rs.getInt("user_id");
				int tkt_id = rs.getInt("ticket_id");
				
				Ticket t = new Ticket(ty, amount, approval, timeStamp, user_id, tkt_id);
				tickets.add(t);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return tickets;
	}

	@Override
	public boolean approveTicket(Ticket t, Connection conn) {
		try {
			Statement stmnt = conn.createStatement();

			String sql = "UPDATE tickets SET approval = 'APPROVED' WHERE ticket_id = "+t.getTicketID();
			
			stmnt.executeUpdate(sql);

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	@Override
	public boolean rejectTicket(Ticket t, Connection conn) {
		try {
			Statement stmnt = conn.createStatement();

			String sql = "UPDATE tickets SET approval = 'REJECTED' WHERE ticket_id = "+t.getTicketID();
			
			stmnt.executeUpdate(sql);

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	@Override
	public Ticket retrieveTicketByID(int id, Connection conn) { // CONTACTING OUR SQL DATABASE AND SELECTING INFORMATION
																// BASED ON TICKET_ID
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub
		String sql = "Select * from tickets where ticket_id = (?)";

		Ticket ticket = null;
		try {

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				Ticket.TYPE ty = Ticket.TYPE.valueOf(rs.getString("tkttype"));
				double amount = rs.getDouble("amount");
				Ticket.APPROVAL approval = Ticket.APPROVAL.valueOf(rs.getString("approval"));
				String timeStamp = rs.getString("submission_date");
				int user_id = rs.getInt("user_id");
				int tkt_id = rs.getInt("ticket_id");
				
				ticket = new Ticket(ty, amount, approval, timeStamp, user_id, tkt_id);

			}

			// System.out.println(user);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("TicketFailed");

		}

		return ticket; // WE SHOULD BE ABLE TO GET THIS TICKET FROM POSTMAN NOW

	}

}
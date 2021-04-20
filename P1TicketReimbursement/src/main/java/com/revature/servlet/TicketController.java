package com.revature.servlet;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Ticket;
import com.revature.models.Ticket.APPROVAL;
import com.revature.models.Ticket.TYPE;
import com.revature.service.TicketService;

public class TicketController {
	
	private TicketService tService;
	
	
	public TicketController(TicketService tService) {
		// TODO Auto-generated constructor stub
		this.tService = tService;
	}

	public void getTicket(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		Ticket t = null;
				
		
		resp.setContentType("json/application"); // SETTING THE RESPONSE OBJECT TO JSON
		
		int id = Integer.parseInt(req.getParameter("ticketID")); // GETTING OUR TICKET ID
		t = tService.getTicket(id); //GETTING THE TICKET USING OUR TICKET SERVICE
		ObjectMapper om = new ObjectMapper();
		resp.setStatus(200);
		try {
			resp.getWriter().write(om.writeValueAsString(t)); // TURNING OUT TICKET (T) INTO A JSON OBJECT
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	
	//WE HAVE TO DECIDE IF WE WANNA CREATE TICKET OBJECTS IN THIS LAYER OR JUST PASS TICKET OBJECT PARAMETERS DOWN TO SERVICE FROM HERE
	
	
	
	public void postTicket(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		
		Ticket t = null;
				
		
		resp.setContentType("json/application"); // SETTING THE RESPONSE OBJECT TO JSON
		
//		Ticket t = Integer.parseInt(req.getParameter("ticketID")); 
//		t = tService.postTicket(t); 
			
		//NEED TO FIND  A WAY TO INSERT A TICKET FROM HERE  AND PASS THE NEW TICKET INTO TSERVICE
		
		ObjectMapper om = new ObjectMapper();
		resp.setStatus(200);
		try {
			resp.getWriter().write(om.writeValueAsString(t)); // TURNING OUT TICKET (T) INTO A JSON OBJECT
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void putTicket(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
			
			
			//THIS STUFF WILL HAVE TO BE CHANGED WHEN WE GET TO SESSIONS, A LOT OF THESE VALUES WILL RETURN NULL FOR NOW
		
			
			Ticket.TYPE ty = Ticket.TYPE.valueOf((String) req.getParameter("tkttype"));
			Ticket.APPROVAL ap = Ticket.APPROVAL.valueOf((String) req.getParameter("approval"));
			double am = Double.parseDouble((String) req.getParameter("amount"));
			//String sm = (String) req.getParameter("submission_date");
			//int ticketid = Integer.parseInt(req.getParameter("ticketID"));
			int empid = Integer.parseInt(req.getParameter("user_id"));
			//Ticket.APPROVAL approval = Ticket.APPROVAL.valueOf(rs.getString("approval"));
		Ticket t = new Ticket(
				ty,
				am, 
				ap, 
				
				null, empid, 0
				
				);
	
				//(TYPE type, double amount, APPROVAL approval, String stamp, int employeeID, int ticketID)
		
		resp.setContentType("json/application"); // SETTING THE RESPONSE OBJECT TO JSON
		
		
		 if(tService.putTicket(t))
		 {
			 ObjectMapper om = new ObjectMapper();
				resp.setStatus(200);
				try {
					resp.getWriter().write(om.writeValueAsString(t)); // TURNING OUT TICKET (T) INTO A JSON OBJECT
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		 } //GETTING THE TICKET USING OUR TICKET SERVICE
		 else {
			 //operation has failed
		 }
		
		
	}

	public void deleteTicket(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		
		Ticket t = null;
				
		
		resp.setContentType("json/application"); // SETTING THE RESPONSE OBJECT TO JSON
		
		int id = Integer.parseInt(req.getParameter("ticketID")); // GETTING OUR TICKET ID
		t = tService.deleteTicket(id); //GETTING THE TICKET USING OUR TICKET SERVICE
		ObjectMapper om = new ObjectMapper();
		resp.setStatus(200);
		try {
			resp.getWriter().write(om.writeValueAsString(t)); // TURNING OUT TICKET (T) INTO A JSON OBJECT
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

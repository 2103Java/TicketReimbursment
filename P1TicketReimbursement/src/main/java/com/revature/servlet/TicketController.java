package com.revature.servlet;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Ticket;
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
		
		Ticket t = null;
				
		
		resp.setContentType("json/application"); // SETTING THE RESPONSE OBJECT TO JSON
		
		int id = Integer.parseInt(req.getParameter("ticketID")); // GETTING OUR TICKET ID
		 if(tService.putTicket(t))
		 {
			 
		 } //GETTING THE TICKET USING OUR TICKET SERVICE
		ObjectMapper om = new ObjectMapper();
		resp.setStatus(200);
		try {
			resp.getWriter().write(om.writeValueAsString(t)); // TURNING OUT TICKET (T) INTO A JSON OBJECT
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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

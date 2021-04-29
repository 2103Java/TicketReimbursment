package com.revature.servlet;

import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Employee;
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
		System.out.println("inside GET TicketController");
		ObjectMapper om = new ObjectMapper();

		resp.setContentType("json/application");

		
		int employeeID = Integer.parseInt(req.getParameter("employeeID"));
		System.out.println(employeeID);
		
		List<Ticket> t = new ArrayList<Ticket>();
				
		
		
		resp.setStatus(200);
		
		t = tService.getTicket(employeeID);
		
		if(t.isEmpty()) {
			try {
				resp.getWriter().write("You don't have any tickets at this time");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else {
			
			try {
				resp.getWriter().write("{ \"ticketArr\":[");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			for(int i = 0; i < t.size(); i++) {
				try {
					
					resp.getWriter().write(om.writeValueAsString(t.get(i)));
					if(i == t.size()-1) {
						resp.getWriter().write("]}");
						break;
					}
					else resp.getWriter().write(",");
					
				} catch (IOException E) {
					E.printStackTrace();
				}
			}
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

		System.out.println("inside PUT TicketController");
		ObjectMapper om = new ObjectMapper();

		resp.setContentType("json/application");

		
		Ticket t = null;
		
		try {
			BufferedReader br = req.getReader();
			String json = br.readLine();
			
			Ticket tmp = om.readValue(json,Ticket.class);
			t = tmp;
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		if(t == null) {
			resp.setStatus(404);
			return;
		}
		
		tService.putTicket(t);
		
		resp.setStatus(200);
		try {
			resp.getWriter().write(om.writeValueAsString(t));
			
		} catch (IOException E) {
			E.printStackTrace();
		}

		
		
	}

	public void deleteTicket(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		
		boolean t = false;
				
		
		resp.setContentType("json/application"); // SETTING THE RESPONSE OBJECT TO JSON
		
		int id = Integer.parseInt(req.getParameter("ticketID")); // GETTING OUR TICKET ID
		t = tService.deleteTicket(id); //GETTING THE TICKET USING OUR TICKET SERVICE
		//ObjectMapper om = new ObjectMapper();
		
		if(t == true)resp.setStatus(200);
		else resp.setStatus(400); //Since it is a delete request we don't actually return anything on a successful delete, do we need an ObjectMapper in this instance?
		
		//try {
			//resp.getWriter().write(om.writeValueAsString(t)); // TURNING OUT TICKET (T) INTO A JSON OBJECT
		//} catch (IOException e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
		//}
		
	}

}

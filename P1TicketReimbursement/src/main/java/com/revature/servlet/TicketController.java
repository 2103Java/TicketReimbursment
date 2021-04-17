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
				
		
		resp.setContentType("json/application");
		
		int id = Integer.parseInt(req.getParameter("ticketID"));
		t = tService.getTicket(id);
		ObjectMapper om = new ObjectMapper();
		resp.setStatus(200);
		try {
			resp.getWriter().write(om.writeValueAsString(t));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}

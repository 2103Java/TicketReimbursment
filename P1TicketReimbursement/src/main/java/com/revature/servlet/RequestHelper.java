package com.revature.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.dao.TicketDao;
import com.revature.dao.TicketDaoImpl;
import com.revature.service.TicketService;

public class RequestHelper  {

	public static TicketDaoImpl tDao = new TicketDaoImpl();
	public static TicketService tService = new TicketService(tDao);
	public static TicketController tcon = new TicketController(tService);
	
	
	
	public void process(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		
		String endPoint = req.getRequestURI();
		String method = req.getMethod();
		
		switch(endPoint)
		{
		
		case"Ticket":
			
			
			switch(method)
			{
				case "GET":
				tcon.getTicket(req,resp);
				
				
				default:
					break;
					
			}
			break;
			
			
		default:
			break;
			
		}
		
		
		
		
	}

}

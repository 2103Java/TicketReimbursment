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
	
	
	
	public void process(HttpServletRequest req, HttpServletResponse resp) { //CHECKING THE END POINT FIRST, THEN THE METHOD
		
		String endPoint = req.getRequestURI();
		String method = req.getMethod();
		
		switch(endPoint)
		{
		
		case"Ticket"://END POINT IS TICKET - LOOKING FOR A SPECIFIC TICKET IN THIS INSTANCE
			
			
			switch(method)
			{
				case "GET": 
				tcon.getTicket(req,resp); // EVERYTHING PASSED THIS POINT IS BASED ON GETTING TICKET INFORMATION
				
				
				default:
					break;
					
			}
			break;
			
			
		default:
			break;
			
		}
		
		
		
		
	}

}

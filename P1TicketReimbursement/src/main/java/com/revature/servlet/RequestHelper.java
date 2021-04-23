package com.revature.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.dao.EmployeeDaoImpl;
import com.revature.dao.TicketDao;
import com.revature.dao.TicketDaoImpl;
import com.revature.service.EmployeeService;
import com.revature.service.TicketService;

public class RequestHelper  {

	public static TicketDaoImpl tDao = new TicketDaoImpl();
	public static TicketService tService = new TicketService(tDao);
	public static TicketController tcon = new TicketController(tService);
	
	public static EmployeeDaoImpl eDao = new EmployeeDaoImpl();
	public static EmployeeService eService = new EmployeeService(eDao);
	public static EmployeeController econ = new EmployeeController(eService);
	
	
	
	public void process(HttpServletRequest req, HttpServletResponse resp) { //CHECKING THE END POINT FIRST, THEN THE METHOD
		
		String endPoint = req.getRequestURI();
		String method = req.getMethod();
		
		
		switch(endPoint)
		{
		
		case"/P1TicketReimbursement/Ticket"://END POINT IS TICKET - LOOKING FOR A SPECIFIC TICKET IN THIS INSTANCE
			
			
			switch(method)
			{
				case "GET": 
					System.out.println("inside get method in helper");
				tcon.getTicket(req,resp); // EVERYTHING PASSED THIS POINT IS BASED ON GETTING TICKET INFORMATION
				break;
				case "POST": 
					tcon.postTicket(req,resp);
					break;
				
				case "PUT": 
					tcon.putTicket(req,resp);
					break;
				
				case "DELETE": 
					tcon.deleteTicket(req,resp);
					break;
				
					
				default:
					break;
					
			}
			break;
			
		
		case "/P1TicketReimbursement/Employee":
			switch(method)
			{
				case "GET": 
				econ.getEmployee(req,resp); // EVERYTHING PASSED THIS POINT IS BASED ON GETTING EMPLOYEE INFORMATION
				break;
				case "POST": 
					econ.postEmployee(req,resp);
					break;
				
				case "PUT": 
					econ.putEmployee(req,resp);
					break;
				
				case "DELETE": 
					econ.deleteEmployee(req,resp);
					break;
				
					
				default:
					break;
					
			}
			break;
		default:
			break;
			
		}
		
		
		
		
	}

}

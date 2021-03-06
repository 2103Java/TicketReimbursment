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
			
			//System.out.println("inside ticket");
			switch(method)
			{
				case "GET": 
					//System.out.println("Entering GET in ticket Controller");
				tcon.getTicket(req,resp); // EVERYTHING PASSED THIS POINT IS BASED ON GETTING TICKET INFORMATION
				break;
				case "POST": 
					//System.out.println("Entering POST in ticket Controller");
					tcon.postTicket(req,resp);
					break;
				
				case "PUT": 
					//System.out.println("Entering PUT in ticket Controller");
					tcon.putTicket(req,resp);
					break;
				
				case "DELETE": 
					//System.out.println("Entering DELETE in ticket Controller");
					tcon.deleteTicket(req,resp);
					break;
				
					
				default:
					
					MasterServlet.loggy.info("Went to default -- this is a terrible sign");
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
					MasterServlet.loggy.info("Going inside employee post from helper");
					econ.postEmployee(req,resp);
					break;
				
				case "PUT": 
					econ.putEmployee(req,resp);
					break;
				
				case "DELETE": 
					econ.deleteEmployee(req,resp);
					break;
				
					
				default:
					System.out.print("Went to default -- this is a terrible sign");
					break;
					
			}
			break;
			
		default:
			break;
			
		}
		
		
		
		
	}

}

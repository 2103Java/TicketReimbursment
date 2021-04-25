package com.revature.servlet;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Employee;
import com.revature.models.Employee.CATEGORY;
import com.revature.models.FinanceManager;
import com.revature.models.Ticket;
import com.revature.service.EmployeeService;
import com.revature.service.TicketService;

public class EmployeeController {

	private EmployeeService eService;

	public EmployeeController(EmployeeService eService) {
		this.eService = eService;
	}

	public void getEmployee(HttpServletRequest req, HttpServletResponse resp) {
		Employee e = null;

		resp.setContentType("json/application");

		int id = Integer.parseInt(req.getParameter("user_id"));
		e = eService.getEmployee(id);
		ObjectMapper om = new ObjectMapper();
		resp.setStatus(200);
		try {
			resp.getWriter().write(om.writeValueAsString(e));
		} catch (IOException E) {
			E.printStackTrace();
		}

	}

	// This will not insert into the DB, instead this is used for login
	// authentication at it is more secure for the user than a GET
	public void postEmployee(HttpServletRequest req, HttpServletResponse resp) {
		
		System.out.println("inside post employee for login");
		ObjectMapper om = new ObjectMapper();

		resp.setContentType("json/application");

		
		Employee tmp = null;
		
		try {
			BufferedReader br = req.getReader();
			String json = br.readLine();
			
			Employee tmp2 = om.readValue(json,Employee.class);
			tmp = tmp2;
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		Employee e = eService.postEmployee(tmp);
		
		
		if(e == null) {
			resp.setStatus(404);
			return;
		}
		
		resp.setStatus(200);
		try {
			resp.getWriter().write(om.writeValueAsString(e));
			
		} catch (IOException E) {
			E.printStackTrace();
		}

	}

	public void putEmployee(HttpServletRequest req, HttpServletResponse resp) {
		Employee e = null;
		String username = req.getParameter("username");
		String pass = req.getParameter("password");
		CATEGORY employment = CATEGORY.valueOf(req.getParameter("type"));
		if (employment.compareTo(CATEGORY.EMPLOYEE) == 0) {
			e = new Employee(username, pass, employment, 0); // putting a new employee the ID should be handled by DB
		} else {
			e = new FinanceManager(0, "admin", username, pass);
		}
		if (eService.putEmployee(e)) {
			ObjectMapper om = new ObjectMapper();
			resp.setStatus(200);
			try {
				resp.getWriter().write(om.writeValueAsString(e)); // TURNING OUT TICKET (T) INTO A JSON OBJECT
			} catch (IOException E) {
				// TODO Auto-generated catch block
				E.printStackTrace();
			}
		} // GETTING THE TICKET USING OUR TICKET SERVICE
		else {
			// operation has failed
		}
	}

	public void deleteEmployee(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub

	}

}

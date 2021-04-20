package com.revature.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MasterServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6352718686718455702L;
	public static RequestHelper rh = new RequestHelper();


	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
		
		System.out.println("Server is up");
		 //http://localhost:9001/P1TicketReimbursement/serverisup
		
		HttpServletRequest  request;
        HttpServletResponse response;
        
        if (!(req instanceof HttpServletRequest &&
                resp instanceof HttpServletResponse)) {
            throw new ServletException("non-HTTP request or response");
        }

        request = (HttpServletRequest) req;
        response = (HttpServletResponse) resp;
       
		rh.process(request,response); //REQUEST COMES IN, NOT EXACTLY SURE WHY WE DO THIS PART ABOVE, BUT BEN DID IT SO HERE WE GO

		
	}

}

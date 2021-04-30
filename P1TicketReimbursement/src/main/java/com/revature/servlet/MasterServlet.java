package com.revature.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class MasterServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6352718686718455702L;
	public static RequestHelper rh = new RequestHelper();
	public static final Logger logger = LogManager.getLogger(MasterServlet.class);

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
		
		System.out.println("Server is up");
		//BasicConfigurator.configure();
		//MasterServlet.logger.error("Server is up");
		 
		
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

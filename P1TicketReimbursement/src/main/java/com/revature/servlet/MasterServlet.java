package com.revature.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MasterServlet extends HttpServlet {

	public static RequestHelper rh = new RequestHelper();


	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
		
		System.out.println("Server is up");

		
		HttpServletRequest  request;
        HttpServletResponse response;
        
        if (!(req instanceof HttpServletRequest &&
                resp instanceof HttpServletResponse)) {
            throw new ServletException("non-HTTP request or response");
        }

        request = (HttpServletRequest) req;
        response = (HttpServletResponse) resp;
       
		rh.process(request,response);

		
	}

}

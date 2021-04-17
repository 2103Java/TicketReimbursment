package com.revature.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {
	
		
		
		private static final String URL = "jdbc:postgresql://database-1.cmeyun7styyj.us-east-2.rds.amazonaws.com/postgres";
		private static final String USERNAME = "JavaDev";
		private static final String PASSWORD = "password";
		
		private static Connection conn;
		
		public static Connection setUpConnection() 
		{
			
			try {
				conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return conn;
				
		}

	}



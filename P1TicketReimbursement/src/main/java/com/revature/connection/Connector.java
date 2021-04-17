package com.revature.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {
	
		
		
	//
		private static final String URL = "jdbc:postgresql://database-1.csd4vggmmxv0.us-east-2.rds.amazonaws.com";
		private static final String USERNAME = "postgres";
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


//
//endpoint
//endpoint: database-1.csd4vggmmxv0.us-east-2.rds.amazonaws.com
//username: postgres
//password: password
//Admin Connection^
//endpoint: database-1.csd4vggmmxv0.us-east-2.rds.amazonaws.com
//username: tktEmployee
//password: password
//Employee connection^ has read/write/update/delete access

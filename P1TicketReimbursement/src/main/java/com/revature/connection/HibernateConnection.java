package com.revature.connection;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateConnection {

	
		
	private static final SessionFactory sf = new Configuration().configure("hibernate.cfb.xml").buildSessionFactory();
	public static final Session session = getSession();
	
	
//	private static final String URL = "jdbc:postgresql://database-1.csd4vggmmxv0.us-east-2.rds.amazonaws.com:5432/postgres";
//	private static final String USERNAME = "postgres";
//	private static final String PASSWORD = "password";
		
		
		
		public static Session getSession() 
		{
			
			return sf.openSession();

	}
		
		

}
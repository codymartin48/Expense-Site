package com.revature.utilities;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
	
	private static Connection connection;
	
	public static Connection getConnection() {
		
		InputStream stream = null;
		Properties props = new Properties();
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//if there's no connection
		if (connection == null) {
			//connect using the credentials file in the resources folder	
			try {
				stream = ConnectionFactory.class.getResourceAsStream("/credentials.properties");
				props.load(stream);
				connection = DriverManager.getConnection(props.getProperty("url"), props.getProperty("username"),
						props.getProperty("password"));
				stream.close();
				return connection;
			}
			catch(IOException e) {
				e.printStackTrace();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		try { //renew the stream if the closeResources method has been called by one of the daos
			if (connection.isClosed()){
				
				stream = ConnectionFactory.class.getResourceAsStream("/credentials.properties");
				props.load(stream);
				connection = DriverManager.getConnection(props.getProperty("url"), props.getProperty("username"),
						props.getProperty("password"));
				stream.close();
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
		return connection;
	}
	
	
}

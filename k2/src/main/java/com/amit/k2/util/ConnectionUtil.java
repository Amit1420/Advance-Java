package com.amit.k2.util;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionUtil {
	public static Connection getConnection() throws ClassNotFoundException, SQLException, IOException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = AppConstants.URL;
		String user = AppConstants.USER_NAME;
		String pass = AppConstants.PASSWORD;
		Connection connection = DriverManager.getConnection(url, user, pass);
		return connection;
		
		
	}

}


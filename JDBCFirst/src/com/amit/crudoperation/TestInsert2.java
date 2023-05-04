package com.amit.crudoperation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestInsert2 {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/m11_e3";
			String user = "root";
			String pass = "root";
			Connection connection = DriverManager.getConnection(url, user, pass);
			Statement statement = connection.createStatement();
			String query="INSERT INTO student VALUES (6,'Abhi','abhi2@gmail.com','Advance Java')";
			int execute = statement.executeUpdate(query);
			System.out.println(execute);
			connection.close();
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		
	}

}

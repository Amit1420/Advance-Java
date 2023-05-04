package com.amit.dynamiccrudoperation;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class TestInsert {
	public static void main(String[] args) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/m11_e3";
			String user = "root";
			String pass = "root";
			Connection connection = DriverManager.getConnection(url, user, pass);
			String query="INSERT INTO student VALUES(?,?,?,?)";
			PreparedStatement ps=connection.prepareStatement(query);
			ps.setInt(1,101);
			ps.setString(2,"Vamshi" );
			ps.setString(3,"vamshi@gmail.com");
			ps.setString(4,"Hibernate");
			
			int res = ps.executeUpdate();
			
			connection.close();
			System.out.println(res+" row of data stored");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}
}

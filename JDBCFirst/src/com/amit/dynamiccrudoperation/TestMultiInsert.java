package com.amit.dynamiccrudoperation;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class TestMultiInsert {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/m11_e3";
			FileInputStream stream = new FileInputStream("mydbinfo.properties");
			Properties pro = new Properties();
			pro.load(stream);
			Connection connection = DriverManager.getConnection(url, pro);
			String query="INSERT INTO student VALUES(?,?,?,?)";
			PreparedStatement ps=connection.prepareStatement(query);
			ps.setInt(1,101);
			ps.setString(2,"Vamshi" );
			ps.setString(3,"vamshi@gmail.com");
			ps.setString(4,"Hibernate");
			ps.addBatch();
			
			ps.setInt(1,102);
			ps.setString(2,"Vamshi" );
			ps.setString(3,"vamshi2@gmail.com");
			ps.setString(4,"Hibernate");
			ps.addBatch();
			
			ps.setInt(1,103);
			ps.setString(2,"Vamshi" );
			ps.setString(3,"vamshi3@gmail.com");
			ps.setString(4,"Hibernate");
			ps.addBatch();
			int[] batch = ps.executeBatch();
			System.out.println(batch.length+" rows of data added");
		} catch (ClassNotFoundException | IOException | SQLException e) {
			e.printStackTrace();
		}
		
	}

}

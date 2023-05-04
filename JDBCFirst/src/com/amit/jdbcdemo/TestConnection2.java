package com.amit.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnection2 {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/m11_e3";
			String user="root";
			String pass="root";
			Connection connection = DriverManager.getConnection(url, user, pass);
			System.out.println("Connected");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

}

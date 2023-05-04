package com.amit.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class TestConnection {

	public static void main(String[] args) {
		try {
			Driver driver=new Driver();
			DriverManager.registerDriver(driver);
			String url="jdbc:mysql://localhost:3306/m11_e3";
			String user="root";
			String pass="root";
			Connection connection = DriverManager.getConnection(url, user, pass);
			System.out.println("Connected");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}

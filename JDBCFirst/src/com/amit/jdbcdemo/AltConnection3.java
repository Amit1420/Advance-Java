package com.amit.jdbcdemo;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class AltConnection3 {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/m11_e3";
			FileInputStream stream = new FileInputStream("mydbinfo.properties");
			Properties pro = new Properties();
			pro.load(stream);
			Connection connection = DriverManager.getConnection(url, pro);
			System.out.println("Connected");
			connection.close();
		} catch (ClassNotFoundException | IOException | SQLException e) {
			e.printStackTrace();
		}

	}

}

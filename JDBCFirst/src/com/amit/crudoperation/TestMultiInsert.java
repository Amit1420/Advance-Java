package com.amit.crudoperation;

import java.io.FileInputStream;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
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
			Statement statement = connection.createStatement();
			String query="INSERT INTO student VALUES (15,'Abhijeet2','abhijeet12@gmail.com','Core Java')";
			String query1="INSERT INTO student VALUES (16,'Abhijeet','abhijeet123@gmail.com','Core Java')";
			String query2="INSERT INTO student VALUES (17,'Abhijeet','abhijeet1234@gmail.com','Core Java')";
			String query3="INSERT INTO student VALUES (18,'Abhijeet','abhijeet1246@gmail.com','Core Java')";
			String update="UPDATE student set name='Akash' where name='Abhijeet'";
			String delete="DELETE FROM student where name='Abhijeet2'";
			statement.addBatch(query);
			statement.addBatch(query1);
			statement.addBatch(query2);
			statement.addBatch(query3);
			statement.addBatch(update);
			statement.addBatch(delete);
			int[] batch = statement.executeBatch();
			for(Integer e:batch)System.out.println(e);
			System.out.println(batch.length+" rows of data added");
			connection.close();
		} catch (ClassNotFoundException | IOException | SQLException e) {
			e.printStackTrace();
		}
	}

}

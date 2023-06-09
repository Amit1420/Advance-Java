package com.amit.dynamiccrudoperation;

import java.io.FileInputStream;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class StudentDAO {
	private Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/m11_e3";
			FileInputStream stream = new FileInputStream("mydbinfo.properties");
			Properties pro = new Properties();
			pro.load(stream);
			connection = DriverManager.getConnection(url, pro);
		} catch (ClassNotFoundException | IOException | SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

	public String saveStudent(Student student) {
		try {
			String query = "INSERT INTO student VALUES(?,?,?,?)";
			Connection connection = getConnection();
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, student.getId());
			ps.setString(2, student.getName());
			ps.setString(3, student.getEmail());
			ps.setString(4, student.getCourse());
			int res = ps.executeUpdate();
			connection.close();
			return res + " row of data stored";
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

	public String updateStudent(Student student) {
		try {
			String query = "UPDATE student SET name=?,email=?,course=? where id=?";
			Connection connection = getConnection();
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, student.getName());
			ps.setString(2, student.getEmail());
			ps.setString(3, student.getCourse());
			ps.setInt(4, student.getId());
			int res = ps.executeUpdate();
			connection.close();
			return res + " row of data updated";
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

	public Student getDataById(int id) {
		return null;
	}

	public List<Student> getAllStudent() {
		String query = "SELECT * FROM student";
		Connection connection = getConnection();
		List<Student> list = null;
		try {
			
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet set = ps.executeQuery();
			if(set.isBeforeFirst())
			{
			list = new ArrayList<>();
			while(set.next())
			{
				Student student=new Student();
				student.setId(set.getInt(1));
				student.setName(set.getString(2));
				student.setEmail(set.getString(3));
				student.setCourse(set.getString(4));
				list.add(student);
			}
			}
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	public String deleteStudentById(int id)
	{
		return null;
		
	}

}

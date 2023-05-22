package com.amit.studentdata.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.amit.studentdata.dto.Student;

public class StudentRepository {
	private Connection getConnection()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/m11_e3";
			String user="root";
			String password="root";
			return DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public String saveStudent(Student student)
	{
		int res=0;
		Connection connection=getConnection();
		String query="INSERT INTO VALUES (?,?,?,?)";
		try {
			PreparedStatement ps=connection.prepareStatement(query);
			ps.setInt(1, student.getId());
			ps.setString(2, student.getName());
			ps.setString(3, student.getEmail());
			ps.setString(4, student.getCourse());
			
			res=ps.executeUpdate();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return student.toString()+" data saved successfully";
	}
	
	public List<Student> getAllData()
	{
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

}

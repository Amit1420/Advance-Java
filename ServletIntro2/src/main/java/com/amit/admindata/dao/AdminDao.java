package com.amit.admindata.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.amit.admindata.dto.AdminDto;

public class AdminDao {
	private Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1:3306/m11_e3";
			String user = "root";
			String pass = "root";
			return DriverManager.getConnection(url, user, pass);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public String saveAdmin(AdminDto dto) {
		Connection con = getConnection();
		if (con != null) {
			String query = "INSERT INTO admin(user_name,password,dept)VALUES(?,?,?)";
			try {
				PreparedStatement ps = con.prepareStatement(query);
				ps.setString(1, dto.getUserName());
				ps.setString(2, dto.getPassword());
				ps.setString(3, dto.getDept());
				int res = ps.executeUpdate();
				con.close();
				return res + " row of data saved sucessfully";
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return "Something went wrong";

	}

	public AdminDto adminLogin(String userName, String password) {
		Connection con = getConnection();
		if (con != null) {
			String query = "SELECT * FROM admin WHERE user_name=? AND password=?";
			try {
				PreparedStatement ps = con.prepareStatement(query);
				ps.setString(1, userName);
				ps.setString(2, password);
				ResultSet set = ps.executeQuery();
				AdminDto dto = new AdminDto();
				while (set.next()) {
					dto.setId(set.getInt(1));
					dto.setUserName(set.getString(2));
					dto.setPassword(set.getString(3));
					dto.setDept(set.getString(4));
				}
				con.close();
				return dto;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	public static void main(String[] args) {
//		AdminDto dto = new AdminDto();
//		dto.setUserName("luffy");
//		dto.setPassword("1234");
//		dto.setDept("development");
		//
		AdminDao dao = new AdminDao();
//		System.out.println(dao.saveAdmin(dto));
		System.out.println(dao.adminLogin("admin1", "1122"));

	}
}

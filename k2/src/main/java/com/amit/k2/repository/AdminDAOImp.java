package com.amit.k2.repository;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.amit.k2.dto.Admin;
import com.amit.k2.util.AppConstants;
import com.amit.k2.util.ConnectionUtil;

public class AdminDAOImp implements AdminDAO{

    private Connection connection;
	@Override
	public String saveAdmin(Admin admin) {
		try {
			String query = "INSERT INTO admin VALUES(?,?,?)";
            connection = ConnectionUtil.getConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            
            ps.setInt(1, admin.getId());
            ps.setString(2,admin.getUserName());
            ps.setString(3,admin.getPassword());
            
            int res = ps.executeUpdate();
            connection.close();
            return res + " row of data stored";
		} catch (ClassNotFoundException | SQLException | IOException e) {
            e.printStackTrace();
        }
		
		return null;
		
		
		
	}

	@Override
	public Admin adminLogin(String userName, String password) {
		Admin admin = null;
        try {
        	connection = ConnectionUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from admin where user_name=? and password=?");
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, password);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                admin = new Admin();
                admin.setId(rs.getInt("id"));
                admin.setUserName(rs.getString("user_name"));
                admin.setPassword(rs.getString("password"));
                System.out.println("You have Successfully Logged In");
            }
            else
            {
            	System.out.println("Invalid admin user_name and password");
            }
        } catch (SQLException | ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        return admin;
    }

}

package com.amit.k2.repository;

import java.util.ArrayList;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.amit.k2.dto.Visitor;
import com.amit.k2.util.AppConstants;
import com.amit.k2.util.ConnectionUtil;

public class VisitorDAOImp implements VisitorDAO {

	@Override
	public String saveVisitor(Visitor visitor) {
		Connection connection;
		try {
			String query = "INSERT INTO registered_visitor VALUES(?,?,?,?,?,?,?,?,?)";
			connection = ConnectionUtil.getConnection();
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, visitor.getId());
			ps.setString(2, visitor.getName());
			ps.setString(3, visitor.getEmail());
			ps.setString(4, visitor.getPhoneNo());
			ps.setDate(5, visitor.getDob());
			ps.setString(6, visitor.getPassword());
			ps.setInt(7, visitor.getAge());
			ps.setString(8, visitor.getGender());
			ps.setString(9, visitor.getAddress());

			int res = ps.executeUpdate();
			if (res > 0) {
				String validquery = "INSERT INTO valid_visitor VALUES(?,?,?,?,?,?,?,?,?)";
				PreparedStatement vps = connection.prepareStatement(validquery);
				vps.setInt(1, visitor.getId());
				vps.setString(2, visitor.getName());
				vps.setString(3, visitor.getEmail());
				vps.setString(4, visitor.getPhoneNo());
				vps.setDate(5, visitor.getDob());
				vps.setString(6, visitor.getPassword());
				vps.setInt(7, visitor.getAge());
				vps.setString(8, visitor.getGender());
				vps.setString(9, visitor.getAddress());

				vps.executeUpdate();
			}
			connection.close();
			return res + " row of data stored";
		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public String updateVisitor(Visitor visitor) {
		Connection connection;
		try {
			String query = "UPDATE registered_visitor SET name=?, email=?, phone_no=?, dob=?, password=?, age=?, gender=?, address=? WHERE id=?";
			connection = ConnectionUtil.getConnection();
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, visitor.getName());
			ps.setString(2, visitor.getEmail());
			ps.setString(3, visitor.getPhoneNo());
			ps.setDate(4, visitor.getDob());
			ps.setString(5, visitor.getPassword());
			ps.setInt(6, visitor.getAge());
			ps.setString(7, visitor.getGender());
			ps.setString(8, visitor.getAddress());
			ps.setInt(9, visitor.getId());

			int res = ps.executeUpdate();
			if (res > 0) {
				String validquery = "UPDATE valid_visitor SET name=?, email=?, phone_no=?, dob=?, password=?, age=?, gender=?, address=? WHERE id=?";
				PreparedStatement vps = connection.prepareStatement(validquery);
				vps.setString(1, visitor.getName());
				vps.setString(2, visitor.getEmail());
				vps.setString(3, visitor.getPhoneNo());
				vps.setDate(4, visitor.getDob());
				vps.setString(5, visitor.getPassword());
				vps.setInt(6, visitor.getAge());
				vps.setString(7, visitor.getGender());
				vps.setString(8, visitor.getAddress());
				vps.setInt(9, visitor.getId());

				vps.executeUpdate();
			}

			connection.close();
			return res + " row of data updated";
		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Visitor getVisitorById(int id) {
		Connection connection;
		try {
			String query = "SELECT * FROM registered_visitor WHERE id=?";
			connection = ConnectionUtil.getConnection();
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Visitor visitor = new Visitor();
				visitor.setId(rs.getInt("id"));
				visitor.setName(rs.getString("name"));
				visitor.setEmail(rs.getString("email"));
				visitor.setPhoneNo(rs.getString("phone"));
				visitor.setDob(rs.getDate("dob"));
				visitor.setPassword(rs.getString("password"));
				visitor.setAge(rs.getInt("age"));
				visitor.setGender(rs.getString("gender"));
				visitor.setAddress(rs.getString("address"));
				return visitor;
			}
			connection.close();
		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Visitor deleteVisitor(int id) {
		Connection connection;
		try {
			Visitor visitor = getVisitorById(id);
			if (visitor != null) {
				String query = "DELETE FROM registered_visitor WHERE id=?";
				connection = ConnectionUtil.getConnection();
				PreparedStatement ps = connection.prepareStatement(query);
				ps.setInt(1, id);
				int res = ps.executeUpdate();

				if (res > 0) {
					// Delete corresponding data from valid_visitor table
					deleteValidVisitor(visitor.getName(), visitor.getEmail());

					connection.close();
					return visitor;
				}
				connection.close();
			}
		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	private boolean deleteValidVisitor(String name, String email) {
		Connection connection;
		try {
			String query = "DELETE FROM valid_visitor WHERE name=? AND email=?";
			connection = ConnectionUtil.getConnection();
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, name);
			ps.setString(2, email);
			int res = ps.executeUpdate();

			connection.close();

			return res > 0;
		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Visitor visitorLogin(String email, String password) {
		Connection connection;
		try {
			String query = "SELECT * FROM registered_visitor WHERE email=? AND password=?";
			connection = ConnectionUtil.getConnection();
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, email);
			ps.setString(2, password);
			Visitor visitor = null;
			// execute the SQL statement and get the result set
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				visitor = new Visitor();
				visitor.setId(rs.getInt("id"));
				visitor.setName(rs.getString("name"));
				visitor.setEmail(rs.getString("email"));
				visitor.setPhoneNo(rs.getString("phone"));
				visitor.setDob(rs.getDate("dob"));
				visitor.setPassword(rs.getString("password"));
				visitor.setAge(rs.getInt("age"));
				visitor.setGender(rs.getString("gender"));
				visitor.setAddress(rs.getString("address"));

				System.out.println(AppConstants.VALID_USER_MESSAGE);
			} else {
				System.out.println("Invalid visitor email and password");
			}
			connection.close();
			return visitor;
		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Visitor> getAllRegisteredVisitor() {
		Connection connection;
		try {
			String query = "SELECT * FROM registered_visitor";
			connection = ConnectionUtil.getConnection();
			PreparedStatement ps = connection.prepareStatement(query);
			List<Visitor> visitorList = new ArrayList<>();
			// execute the SQL statement and get the result set
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Visitor visitor = new Visitor();
				visitor.setId(rs.getInt("id"));
				visitor.setName(rs.getString("name"));
				visitor.setEmail(rs.getString("email"));
				visitor.setPhoneNo(rs.getString("phone"));
				visitor.setDob(rs.getDate("dob"));
				visitor.setPassword(rs.getString("password"));
				visitor.setAge(rs.getInt("age"));
				visitor.setGender(rs.getString("gender"));
				visitor.setAddress(rs.getString("address"));
				visitorList.add(visitor);
			}
			connection.close();
			return visitorList;
		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Visitor> getAllValidVisitor() {
		Connection connection;
		try {
			String query = "SELECT * FROM registered_visitor WHERE email LIKE '%@%' AND password IS NOT NULL AND dob IS NOT NULL";
			connection = ConnectionUtil.getConnection();
			PreparedStatement ps = connection.prepareStatement(query);
			List<Visitor> visitorList = new ArrayList<>();
			// execute the SQL statement and get the result set
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Visitor visitor = new Visitor();
				visitor.setId(rs.getInt("id"));
				visitor.setName(rs.getString("name"));
				visitor.setEmail(rs.getString("email"));
				visitor.setPhoneNo(rs.getString("phone"));
				visitor.setDob(rs.getDate("dob"));
				visitor.setPassword(rs.getString("password"));
				visitor.setAge(rs.getInt("age"));
				visitor.setGender(rs.getString("gender"));
				visitor.setAddress(rs.getString("address"));
				visitorList.add(visitor);
			}
			connection.close();
			return visitorList;
		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Visitor getValidVisitorById(int id) {
		Connection connection;
		try {
			String query = "SELECT * FROM registered_visitor WHERE id=? ";
			connection = ConnectionUtil.getConnection();
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			Visitor visitor = null;
			if (rs.next()) {
				visitor = new Visitor();
				visitor.setId(rs.getInt("id"));
				visitor.setName(rs.getString("name"));
				visitor.setEmail(rs.getString("email"));
				visitor.setPhoneNo(rs.getString("phone"));
				visitor.setDob(rs.getDate("dob"));
				visitor.setPassword(rs.getString("password"));
				visitor.setAge(rs.getInt("age"));
				visitor.setGender(rs.getString("gender"));
				visitor.setAddress(rs.getString("address"));
			}
			connection.close();
			return visitor;
		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}

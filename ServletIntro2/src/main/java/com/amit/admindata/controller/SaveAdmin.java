package com.amit.admindata.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.amit.admindata.dao.AdminDao;
import com.amit.admindata.dto.AdminDto;

@WebServlet("/newadmin")
public class SaveAdmin extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException
	{
		String userName = req.getParameter("username");
		String password = req.getParameter("password");
		String dept = req.getParameter("dept");
		
		AdminDto dto= new AdminDto();
		dto.setDept(dept);
		dto.setUserName(userName);
		dto.setPassword(password);
		AdminDao dao= new AdminDao();
		PrintWriter out = resp.getWriter();
		out.println(dao.saveAdmin(dto));
	}
}
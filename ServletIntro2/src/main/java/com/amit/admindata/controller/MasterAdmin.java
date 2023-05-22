package com.amit.admindata.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/masteradmin")
public class MasterAdmin extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException
	{
		PrintWriter out = resp.getWriter();
		Object object = req.getAttribute("servlet");
		System.out.println(object);
		out.write("<h1>"+"Welcome Admin to the Master Admin menu"+"</h1>");
		out.write("<a href=saveAdmin.html> To save new Admin</a>");
	}

}


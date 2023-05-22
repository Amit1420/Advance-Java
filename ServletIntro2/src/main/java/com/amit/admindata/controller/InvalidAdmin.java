package com.amit.admindata.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/invalidadmin")
public class InvalidAdmin extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException
	{
		PrintWriter out = resp.getWriter();
		out.write("<h1>"+" Invalid Username And Password"+"</h1>");
		//out.write("<a href=saveAdmin> To back to adminlogin</a>");
	}

}

package com.amit.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/login2")
public class Login2 extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userName="Amit1420";
		String passWord="Amitraaz@123";
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		System.out.println("Login class executed");
		PrintWriter writer = resp.getWriter();
		if(username.equals(userName)&&password.equals(passWord))
		{
			writer.println("<h1>"+"Login successfully"+"</h1>");
		}
		else
		{
			writer.println("<h1>"+"Invalid username and password"+"</h1>");
		}
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	System.out.println("doGet() from Login2");
	}
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	System.out.println("doPut() getting executed");
	 
	}


}

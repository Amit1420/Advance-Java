package com.amit.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class Login extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		String name=req.getParameter("name");
		String password=req.getParameter("password");
		if(name.equals("luffy")&& password.equals("1111"))
		{
			RequestDispatcher rd = req.getRequestDispatcher("valid");
			rd.forward(req, resp);
			
		}else
		{
			RequestDispatcher rd = req.getRequestDispatcher("invalid");
			rd.forward(req, resp);
		}
	}

}
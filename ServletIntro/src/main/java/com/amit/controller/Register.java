package com.amit.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Register implements Servlet {

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");
		String dob = req.getParameter("dob");
		String address = req.getParameter("address");
		System.out.println(name);
		System.out.println(email);
		System.out.println(phone);
		System.out.println(dob);
		System.out.println(address);

		System.out.println("Register class getting executed");
		PrintWriter writer = res.getWriter();
		res.setContentType("text/html");
		writer.println("<h1>"+"Thank you for registration your data is saved"+"</h1>");

	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}

package com.amit.controller;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.amit.studentdata.dto.Student;

public class Save extends GenericServlet {



	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
	  String name = req.getParameter("name");
	  String email=req.getParameter("email");
	  String phone = req.getParameter("phone");
	  ServletContext servletContext = getServletContext();
	  String parameter = servletContext.getInitParameter("value");
	  servletContext.setAttribute("stu",new Student());
	  String parameter2 = getServletConfig().getInitParameter("one");
	  
	  
	  System.out.println(parameter);
	  System.out.println(parameter2);
	  System.out.println(name);
	  System.out.println(email);
	  System.out.println(phone);
	  
		System.out.println("Save class getting executed");
		
	}

	
}

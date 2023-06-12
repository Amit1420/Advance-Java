package com.amit.passwordlocker.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.amit.passwordlocker.entity.UserDetails;
import com.amit.passwordlocker.service.UserServiceImp;



@WebServlet("/saveUser")
public class SaveUser extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserDetails user = new UserDetails();
		user.setName(req.getParameter("name"));
		user.setGender(req.getParameter("gender"));
		user.setDob(Date.valueOf(req.getParameter("dob")));
		user.setEmail(req.getParameter("email"));
		user.setPhoneNumber(req.getParameter("phoneNumber"));
		user.setPassword(req.getParameter("password"));
		UserServiceImp service = new UserServiceImp();
		String msg = service.saveUser(user);
		HttpSession session = req.getSession();
		session.setAttribute("saveMessage", msg);
		resp.sendRedirect("userLogin.jsp");
	}

}

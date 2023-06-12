package com.amit.sessionimplementation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/session3")
public class SessionClass3 extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		DataClass data= (DataClass) session.getAttribute("data");
		System.out.println(data);
		List<DataClass> list= new ArrayList<>();
		list.add(new DataClass(101,"Amit","amitkumar80999@gmail.com"));
		list.add(new DataClass(102,"Anmol","anmolkumar80999@gmail.com"));
		list.add(new DataClass(103,"Jatin","jatinkumar80999@gmail.com"));
		list.add(new DataClass(104,"Ankit","ankitkumar80999@gmail.com"));
		list.add(data);
		session.setAttribute("list", list);
		session.setMaxInactiveInterval(600);
		resp.sendRedirect("dataprinter.jsp");
		
		
		
	}

}

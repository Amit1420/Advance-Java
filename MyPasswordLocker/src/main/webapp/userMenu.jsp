<%@page import="com.amit.passwordlocker.entity.UserDetails"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Menu</title>
</head>
<body>
	<h1>Welcome to the user menu</h1>
	<% UserDetails user = (UserDetails) session.getAttribute("loggeduser");
		if(user != null){
			%> <h1>Welcome to the user menu</h1> <% 
		}
		else { %>
		 <h1>please login to use user function</h1> 
		 <a href="userLogin.jsp">back to login</a>
		 <%
		}
	%>
</body>
</html>
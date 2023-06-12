<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1><%= (String)session.getAttribute("SaveMessage") %></h1>
	<h1>User Login</h1>	
	<form action="userLogin" method="post">
		email = <input type="email" name="email"><br>
		password = <input type="password" name="password">
		<input type="submit">
	</form>
	<a href="home.jsp">Back to Home page</a>
</body>
</html>
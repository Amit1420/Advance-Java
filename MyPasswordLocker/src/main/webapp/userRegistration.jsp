<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="saveUser" method="post">
		Name : <input type="text" name = "name"><br>
		gender : <input type="text" name = "gender"><br>
		DOB : <input type="date" name = "dob"><br>
		Phone Number : <input type="number" name = "phoneNumber"><br>
		Email : <input type="email" name = "email"><br>
		Password : <input type="password" name = "password"><br>
		<input type="submit" value="Submit">
	</form>
</body>
</html>
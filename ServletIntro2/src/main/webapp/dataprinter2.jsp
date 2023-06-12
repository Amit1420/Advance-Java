<%@page import="com.amit.sessionimplementation.DataClass"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	List<DataClass> list = (List<DataClass>) request.getAttribute("dataList");
	%>
	<%
	for (DataClass e : list) {
	%>
	<h2>
		<%=e%></h2>
	<br>
	<%
	}
	%>
	<%
	for (int i = 0; i <= 4; i++)
	{
	%>
	<h3>${list.get(i)}</h3><br>
	<%} %>
</body>
</html>
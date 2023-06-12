
<%@page import="com.amit.entity.Note"%>
<%@page import="java.util.List"%>
<%@page import="org.hibernate.Session"%>
<%@page import="org.hibernate.Query"%>
<%@page import="com.amit.helper.FactoryProvider"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Notes : Note Taker</title>
<%@include file="all_js_css.jsp"%>
</head>
<body>
	<div>
		<%@include file="navbar.jsp"%>
		<br>
		<h1 class="text-uppercases">All Notes :</h1>
		<div class="row">
			<div class="col-12">
				<%
				Session s = FactoryProvider.getFactory().openSession();
				Query q = s.createQuery("from Note");
				List<Note> list = q.list();

				for (Note n : list) {
				%>
				<div class="card mt-3 "">
					<img class="card-img-top m-4 mx-auto" style="max-width: 100px"
						src="image/copy-writing.png" alt="Card image cap">
					<div class="card-body px-5">
						<h5 class="card-title"><%=n.getTitle()%></h5>
						<p class="card-text"><%=n.getContent()%></p>
						<div class="container text-center mt-2">
						<a href="DeleteServlet?note_id="<%=n.getId() %> class="btn btn-danger">Delete</a>
						<a href="UpdateServlet" class="btn btn-primary">Update</a>
						</div>
					</div>
				</div>
				<%
				}
				s.close();
				%>
			</div>
		</div>
	</div>


</body>
</html>
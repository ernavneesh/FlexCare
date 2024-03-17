<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%
	if(session.getAttribute("fname")==null){
		response.sendRedirect("login.jsp");
	}
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User logged in!</title>
</head>
<body>
<h1>Welcome <%= session.getAttribute("fname") %></h1>
<button>
<a href="logout">Logout</a></button>

</body>
</html>
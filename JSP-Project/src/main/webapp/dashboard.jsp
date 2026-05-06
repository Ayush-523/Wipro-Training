<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String email =request.getParameter("email");
String password = request.getParameter("password");


if(password==null || email.isEmpty())
	response.sendRedirect("error.jsp");
		out.println();
%>
	
<h2> welcome</h2>
</body>
</html>
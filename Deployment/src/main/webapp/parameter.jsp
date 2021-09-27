<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	//http://localhost:8080/Deployment/parameter.jsp?name=quyet
	String name = request.getParameter("name");
	out.println("Name param is: "+name);
%>

</body>
</html>
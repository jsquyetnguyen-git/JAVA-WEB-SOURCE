<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<p><a href="<%= response.encodeUrl(request.getContextPath() + "/Controller?action=login") %>">Click here to login</a></p>
<p><a href="<%= response.encodeUrl(request.getContextPath() + "/Controller?action=createaccount") %>">Click here to create a new account</a></p>
</body>
</html>
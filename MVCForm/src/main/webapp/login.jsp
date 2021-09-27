<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="/MVCForm/Controller" method="post">
	<input type="hidden" name = "action" value ="dologin" /><p/>
	Email: <input type = "text" name = "email" value="<%= request.getAttribute("email") %>"/><p/> 
	Pass: <input type ="text" name = "password" value ="<%= request.getAttribute("password") %>"/>
	<input type ="submit" value ="OK"/>
	
	<h2><%= request.getAttribute("validationmessage") %></h2>
</form>
</body>
</html>



<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@ page import = "demo.*" %>
	<% Cart cart = (Cart)session.getAttribute("cart"); %>
	
	Items in cart: <%= cart==null? "error" : cart.getTotalItems() %>
	
	<a href="<%= response.encodeURL(request.getContextPath() + "/showCart2.jsp") %>">Click here to go to showCart2.jsp</a>
	
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%! int count = 1; %>
	
	<!-- Declaration tag -->
	<%!
		// instance variable
		private String name = "Quyet"; 
	
		private String getInfo(){
			return "Hello there.";
		}
	%>
	
	<% out.println(getInfo()); %>
	<p/>
	<% out.println(count); %>
	
</body>
</html>
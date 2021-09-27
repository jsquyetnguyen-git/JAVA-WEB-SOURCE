<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<!-- static include: content change infrequently -->
	<%@ include file ="copyright.txt"%>
	
	</br>
	<!-- dynamic include --- content change a lot -->
	<jsp:include page = "update.txt" />
	
	<p/>
	<!-- Must use static include if it's got java code in it that we want to access -->
	<%@ include file = "variables.jsp" %>
	<%= name %>

	<p/>
	<!-- must use include jsp tag if you don't know what file you want till run time -->
	
	<% String id = request.getParameter("id"); %>
	<% if(id==null){ %>
	
	<jsp:include page = "idnotfound.html"/>
	
	<% }else{ %>
	<jsp:include page = "idfound.html" />
	<%} %>
	
</body>
</html>
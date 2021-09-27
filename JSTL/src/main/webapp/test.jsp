<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:set var="j" value="4,3,2,1"/>
<c:forEach items="${j}" var="item" begin="0" end="1">
<c:out value="${item}" default="abc"/>
        </c:forEach>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<jsp:useBean id="user1" class="beans.User" scope = "session" ></jsp:useBean>
<jsp:setProperty property="*" name="user1"/>


<%
String action = request.getParameter("action");
	// && action.equals("formsubmit")
	if(action!=null&& action.equals("formsubmit")){
	if(user1.validate()){
		request.getRequestDispatcher("/Controller").forward(request, response);
	}
}
%>

<h2><jsp:getProperty property="message" name="user1"/></h2>
<form action="/Forms/selfvalidatingform.jsp" method = "Post">
	<input type = "text" name = "email" value="<jsp:getProperty property="email" name="user1"/>"><p/>
	<input type ="text" name = "password" value='<jsp:getProperty property="password" name="user1"/>' ><p/>
	<input type="hidden" name="action" value = "formsubmit">
	<input type="submit"  value = "OK">
</form>

</body>
</html>
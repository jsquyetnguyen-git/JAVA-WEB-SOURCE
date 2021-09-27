<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU"
	crossorigin="anonymous">

</head>
<body>

<div class="modal-dialog shadow-lg">
        <div class="modal-content">
            <div class="modal-header">
                <h5>Login</h5>
            </div>
            <div class="modal-body">
                <form action="<%=response.encodeUrl(request.getContextPath() + "/Controller?action=dologin") %>" method = "post">
                	<input type = "hidden" name = "action" value = "login"/>
                    <div class="md-form mb-4">
                        <input type="text" name="email" placeholder="Enter email" class="form-control" value="<%= request.getAttribute("email") %>">
                    </div>
                    <div class="md-form mb-2">
                        <input type="password" name="password" placeholder="Enter password" class="form-control" value="<%= request.getAttribute("password") %>">
                    </div>
                    
                    <p class = "text-center text-danger"><%= request.getAttribute("message") %></p>

                    <div class="d-flex justify-content-center">
                        <button type="submit" class="btn btn-outline-secondary">Login</button>
                    </div>
                </form>
            </div>
        </div>
    </div>

</body>
</html>
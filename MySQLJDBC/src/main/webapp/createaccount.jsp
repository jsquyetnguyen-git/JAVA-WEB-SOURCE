<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create New Account</title>
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
				<h5>Create New Account</h5>
			</div>
			<div class="modal-body">
				<form action="<%=response.encodeUrl(request.getContextPath() + "/Controller?action=createaccount") %>" method="post">
					<input type="hidden" name="action" value = "createaccount">
					<div class="md-form mb-2">
						Email <input type="text" name="email" class="form-control">
					</div>
					
					<div class="md-form mb-2">
						Password <input type="password" name="password"
							class="form-control">
					</div>
					
					<div class="md-form mb-2">
						Repeat password <input type="password" name="repassword"
							class="form-control">
					</div>

					<p class="text-center text-danger"><%=request.getAttribute("message")%></p>

					<div class="d-flex justify-content-center">
						<button type="submit" class="btn btn-outline-secondary">Register</button>
					</div>
				</form>
			</div>
		</div>
	</div>

</body>
</html>
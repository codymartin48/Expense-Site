<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<link href="pageStyle.css" rel="stylesheet" type="text/css">
<head>
<meta charset="ISO-8859-1">
<title>User Info</title>

<%
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");

	if (session.getAttribute("username") == null) {
		response.sendRedirect("employeeLogin.jsp");
	}
%>

</head>
<body>
	<h2 class="jumboTron">User Info</h2>
	<hr>

	<form action="EmployeeReturnHome" method="get" accept-charset="utf-8">
		<div class="form-group">
				<button type="submit" class="button btn">Home</button>
		</div>
	</form>

	<form action="UpdateInfo" method="POST" accept-charset="utf-8">
		<div class="form-group">
			<label for="amount" class="col-sm-4 control-label">Username:
				<%
				out.println(session.getAttribute("username"));
			%>
			</label>
		</div>
		<div class="form-group">
			<label for="amount" class="col-sm-4 control-label">Manager Username:
				<%
				out.println(session.getAttribute("manager"));
			%>
			</label>
		</div>
		<div class="form-group">
			<label for="amount" class="col-sm-4 control-label">Manager:
				<%
				out.println(session.getAttribute("ismanager"));
			%>
			</label>
		</div>
		<div class="form-group">
			<label for="description" class="col-sm-4 control-label">First
				Name:</label>
			<div class="col-sm-5">
				<input type="text" class="form-control" id="firstname"
					name="firstname"
					placeholder=<%out.println(session.getAttribute("firstname"));%>
					required="required" />
			</div>
		</div>
		<div class="form-group">
			<label for="image" class="col-sm-4 control-label">Last Name:</label>
			<div class="col-sm-5">
				<input type="text" class="form-control"
					placeholder=<%out.println(session.getAttribute("lastname"));%>
					id="lastname" name="lastname" />
			</div>

		</div>
		<div class="form-group">
			<div class="col-sm-offset-4 col-sm-1">
				<button type="submit" class="button btn">Update User Info</button>
			</div>
		</div>
	</form>

	<hr>
</body>
<p class="center">The Company's Official Reimbursement System</p>
	<p class="center">
		Contact information: <a href="mailto:someone@example.com">
			someone@example.com</a>.
	</p>
</html>
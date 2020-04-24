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
<title>Insert title here</title>

<%
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");

	if (session.getAttribute("username") == null) {
		response.sendRedirect("employeeLogin.jsp");
	}
%>

</head>
<body>
	<h2 class="jumboTron">Search Employee Requests</h2>
	<hr>
	<form action="EmployeeReturnHome" method="get" accept-charset="utf-8">
		<div class="form-group">
				<button type="submit" class="btn btn-info">Home</button>
		</div>
	</form>
	<br>
	<form action="OneEmployeeResults" method="get">
		<div class="form-group">
			<label for="amount" class="col-sm-4 control-label">Username:</label>
			<div class="col-sm-5">
				<input type="text" class="form-control" id="username"
					name="username" placeholder="Username" required="required" />
			</div>
		</div>
		<br>
		<div class="form-group">
			<div class="col-sm-offset-4 col-sm-1">
				<button type="submit" class="btn btn-info">Submit</button>
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
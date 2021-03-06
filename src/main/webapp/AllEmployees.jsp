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
	<h2 class="jumboTron">Employees</h2>
	<hr>
	<form action="EmployeeReturnHome" method="get" class="form-horizontal"
		accept-charset=utf-8>
		<div class="form-group">
			<button type="submit" class="button btn">Home</button>
		</div>
	</form>

	<table border="1" class="table table-striped">
	<hr>
		<thead>
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Username</th>
				<th>Manager</th>
			</tr>
		</thead>
		<tbody id="tbody">

		</tbody>
	</table>
	<hr>
	<script type="text/javascript" src="Scripts/AllEmployees.js">
		
		</script>
</body>
<p class="center">The Company's Official Reimbursement System</p>
	<p class="center">
		Contact information: <a href="mailto:someone@example.com">
			someone@example.com</a>.
	</p>
</html>
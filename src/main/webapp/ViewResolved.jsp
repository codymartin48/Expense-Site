<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<html>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<link href="pageStyle.css" rel="stylesheet" type="text/css">
<head>
<meta charset="ISO-8859-1">
<title>Pending Requests</title>

<%
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");

	if (session.getAttribute("username") == null) {
		response.sendRedirect("employeeLogin.jsp");
	}
%>

</head>
<body>
	<h2 class="jumboTron">Resolved Requests</h2>
	<hr>
	<form action="EmployeeReturnHome" method="get" accept-charset="utf-8"
	class="form-horizontal">
		<div class="form-group">
				<button type="submit" class="button btn">Home</button>
		</div>
	</form>
	<br>
	<table class="table table-striped" border="1">
		<hr>
		<thead>
			<tr>
				<th>Amount</th>
				<th>Requester</th>
				<th>Description</th>
				<th>Image</th>
			</tr>
		</thead>
		<tbody id="tbody">

		</tbody>

	</table>
	<hr>
	<script type="text/javascript" src="Scripts/resolvedRequests.js">
		
	</script>
</body>
<p class="center">The Company's Official Reimbursement System</p>
	<p class="center">
		Contact information: <a href="mailto:someone@example.com">
			someone@example.com</a>.
	</p>
</html>
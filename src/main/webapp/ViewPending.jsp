<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="ISO-8859-1"%>


<html>
<%
	if (session.getAttribute("username") == null) {
		response.sendRedirect("employeeLogin.jsp");
	}
%>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
	<link href="pageStyle.css" rel="stylesheet" type="text/css">
<head>
<meta charset="utf-8">

<title>Pending Requests</title>
</head>
<body>
<div class="jumboTron">
	<h2> Pending Requests</h2>
	<hr>
</div>
	<br>
	<form action="EmployeeReturnHome" method="get" class="form-horizontal"
		accept-charset=utf-8>
		<div class="form-group">
			<button type="submit" class="button btn">Home</button>
		</div>
	</form>
	<br>
	<form action="NewRequest" method="get" class="form-horizontal"
		accept-charset=utf-8>
		<div class="form-group">
			<button type="submit" class="button btn">Make New Request</button>
		</div>
	</form>
	<br>
	<table class="table table-striped"border="1">
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
	<script type="text/javascript" src="Scripts/requestTable.js">
		
	</script>
</body>
<p class="center">The Company's Official Reimbursement System</p>
	<p class="center">
		Contact information: <a href="mailto:someone@example.com">
			someone@example.com</a>.
	</p>
</html>
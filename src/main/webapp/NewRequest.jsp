<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="ISO-8859-1"%>

<html>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<link href="pageStyle.css" rel="stylesheet" type="text/css">
<head>
<meta charset="utf-8">
<title>New Request</title>

<%
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");

	if (session.getAttribute("username") == null) {
		response.sendRedirect("employeeLogin.jsp");
	}
%>

</head>
<body>
	<h2 class="jumboTron">New Request</h2>
	<hr>
	<form action="EmployeeReturnHome" method="get" accept-charset="utf-8">
		<div class="form-group">
			<button type="submit" class="button btn">Home</button>
		</div>
	</form>

	<form action="SubmitNewRequest" method="post"
		enctype="multipart/form-data">
		<div class="form-group">
			<label for="amount" class="col-sm-4 control-label">Amount:</label>
			<div class="col-sm-5">
				<input type="number" step=".01" class="form-control" id="amount"
					name="amount" placeholder="amount" required="required" />
			</div>
		</div>
		<div class="form-group">
			<label for="description" class="col-sm-4 control-label">Description:</label>
			<div class="col-sm-5">
				<input type="text" class="form-control" id="description"
					name="description" placeholder="description" required="required" />
			</div>
		</div>
		<div class="form-group">
			<label for="image" class="col-sm-4 control-label">Receipt:</label>
			<div class="col-sm-5">
				<input type="file" class="form-control" id="image" name="image" />
			</div>

		</div>
		<div class="form-group">
			<div class="col-sm-offset-4 col-sm-1">
				<button type="submit" class="button btn">Submit</button>
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
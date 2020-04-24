<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="ISO-8859-1"%>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<!DOCTYPE html>
<html>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<link href="pageStyle.css" rel="stylesheet" type="text/css">
<head>
<meta charset="ISO-8859-1">
<title>Employee Login</title>
</head>
<body>

	<h1 class="jumboTron">Employee Login</h1>
	<hr>

	<form action="EmployeeHome" method="get" class="form-horizontal">
		<div class="form-group">
			<label for="title" class="col-sm-4 control-label">Username</label>
			<div class="col-sm-5">
				<input type="text" class="form-control" id="username"
					name="username" placeholder="Username" required="required" />
			</div>
		</div>
		<div class="form-group">
			<label for="price" class="col-sm-4 control-label">Password</label>
			<div class="col-sm-5">
				<input type="password" step="0.01" class="form-control"
					id="password" name="password" placeholder="Password"
					required="required" />
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-4 col-sm-1">
				<button type="submit" class="button btn">Login</button>
			</div>
		</div>
	</form>

</body>
<hr>
<footer>
	<p class="center">The Company's Official Reimbursement System</p>
	<p class="center">
		Contact information: <a href="mailto:someone@example.com">
			someone@example.com</a>.
	</p>
</footer>
</html>
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
<title>Manager Home</title>

<%
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	if (session.getAttribute("username") == null) {
		response.sendRedirect("employeeLogin.jsp");
	}
%>

</head>
<body>
	<h1 class="jumboTron">Manager Home</h1>
	<hr>
	<h2>
		Welcome
		<%
		out.println(session.getAttribute("firstname") + " " + session.getAttribute("lastname"));
	%>
	</h2>
	
	<div class="row" style="border:4px solid #444">
		<div class="column" style="padding-left: 10px; padding-right: 20px">
			<h3>Employee Options</h3>
		</div>
		<div class="column">
			<h3>Manager Options</h3>
		</div>
	</div>
	<div class="row" style="border:4px solid #444">
		<div class="column">
			<form action="ViewInfo" method="get" class="form-horizontal">
				<div class="form-group">
					<button type="submit" class="button btn">View Info</button>
				</div>
			</form>

			<form action="ViewPending" method="get" class="form-horizontal">
				<div class="form-group">
					<button type="submit" class="button btn">View My Pending
						Requests</button>
				</div>
			</form>

			<form action="ViewResolved" method="get" class="form-horizontal">
				<div class="form-group">
					<button type="submit" class="button btn">View My Resolved
						Requests</button>
				</div>
			</form>

			<form action="NewRequest" method="get" class="form-horizontal">
				<div class="form-group">
					<button type="submit" class="button btn">Make New Request</button>
				</div>
			</form>
		</div>

		<div class="column">

			<form action="MyEmployeesPending" method="get"
				class="form-horizontal">
				<div class="form-group">
					<button type="submit" class="button btn">View Pending
						Requests of Employees</button>
				</div>
			</form>

			<form action="AllEmployees" method="get" class="form-horizontal">
				<div class="form-group">
					<button type="submit" class="button btn">View All
						Employees</button>
				</div>
			</form>

			<form action="OneEmployeeRequests" method="get"
				class="form-horizontal">
				<div class="form-group">
					<button type="submit" class="button btn">View an
						Employee's Requests</button>
				</div>
			</form>

			<form action="AllEmployeesResolved" method="get"
				class="form-horizontal">
				<div class="form-group">
					<button type="submit" class="button btn">View all Resolved
						Requests</button>
				</div>
			</form>
		</div>



		
	</div>
	<form action="Logout" method="get" class="form-horizontal"
			accept-charset=utf-8>
			<div class="form-group">
				<button type="submit" class="button btn">Logout</button>
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
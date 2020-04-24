<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>


<html>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<link href="pageStyle.css" rel="stylesheet" type="text/css">
<head>
<meta charset="utf-8">
<title>Employee Home</title>


<%
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	if (session.getAttribute("username") == null) {
		response.sendRedirect("employeeLogin.jsp");
	}
%>

</head>
<body>
	<h1 class="jumboTron">Employee Home</h1>
	<hr>
	<h2>
		Welcome
		<%
		out.println(session.getAttribute("firstname") + " " + session.getAttribute("lastname"));
	%>
	</h2>
	<br>
	<div class="buttonDiv">
		<form action="ViewInfo" method="get" class="form-horizontal"
			accept-charset=utf-8>
			<div class="form-group">
				<button type="submit" class="button btn">View Info</button>
			</div>
		</form>
		<br>
		<form action="ViewPending" method="get" class="form-horizontal"
			accept-charset=utf-8>
			<div class="form-group">
				<button type="submit" class="button btn">View Pending
					Requests</button>
			</div>
		</form>
		<br>
		<form action="ViewResolved" method="get" class="form-horizontal"
			accept-charset=utf-8>
			<div class="form-group">
				<button type="submit" class="button btn">View Resolved
					Requests</button>
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
		<form action="Logout" method="get" class="form-horizontal"
			accept-charset=utf-8>
			<div class="form-group">
				<button type="submit" class="button btn">Logout</button>
			</div>
		</form>
	</div>
	<hr>
</body>
<footer>
	<p class="center">The Company's Official Reimbursement System</p>
	<p class="center">
		Contact information: <a href="mailto:someone@example.com">
			someone@example.com</a>.
	</p>
</footer>
</html>
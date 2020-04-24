<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Manager Login</title>
</head>
<body>
	<h2>Manager Login</h2>
	<form action="managerLogin" method="post" class="form-horizontal">
		
		<div class="form-group">
			<label for="username">Username: </label>
			<div class="form-group">
				<input type="text" id="username" class="form-control">
			</div>
		</div>
		<br>
		<div class="form-group">
			<label for="password">Password: </label>
			<div>
				<input type="password" id="password" class="form-control">
			</div>
		</div>
		<br>
		<button type="submit" class="btn button">Submit</button>
	</form>

</body>
</html>
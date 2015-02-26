<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Failed</title>
</head>
<body>
	<jsp:include page="/WEB-INF/views/header.jsp" />
	<div align="center" style="background-color: red">
		<h2>Login Failed</h2>

		<b>Username and password combination does not match. Please try
			again.</b> <br>
		<br>
		<input type="button" value="Go back to Login page"
			onclick="location.href = 'http://localhost:8080/StudentCatalog/login';" />

	</div>
</body>
</html>
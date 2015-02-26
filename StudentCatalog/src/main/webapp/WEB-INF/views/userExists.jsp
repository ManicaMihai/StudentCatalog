<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="/WEB-INF/views/header.jsp"/>
	
	<div align="center" style="background-color: red">
		<h2>Login Failed</h2>

		<b>Username is already in use. Please enter new username.</b><br>
		<br> <input type="button" value="Go back to Register page"
			onclick="location.href = 'http://localhost:8080/StudentCatalog/register';" />

		<br>OR<br> <input type="button"
			value="Go back to Login page"
			onclick="location.href = 'http://localhost:8080/StudentCatalog/login';" />

	</div>

</body>
</html>
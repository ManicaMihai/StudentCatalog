<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<html>
<head>
<title>Login</title>
<style type="text/css">
body {
	background-color: #B8E6E6;
}
</style>
</head>
<body>
	<jsp:include page="/WEB-INF/views/header.jsp" />
	<div align="center" style="margin-top: 100px">
		<c:url var="loginAction" value="/user/login"></c:url>

		<form:form action="${loginAction}" commandName="userData"
			method="post">

			<form:label path="username">
				<spring:message text="Username:" />
			</form:label>
			<form:input required="required" pattern=".{5,}"
				title="5 characters minimum" path="username" />
			<br>
			<br>

			<form:label path="password">
				<spring:message text="Password: &nbsp" />
			</form:label>
			<form:input type="password" required="required"
				pattern="[A-Z][0-9a-zA-Z]{5,}"
				title="First letter must be uppercase and password must contain at least one digit, 5 characters minimum"
				path="password" />
			<br>
			<br>
			<br>

			<input type="submit" value="<spring:message text="Login"/>" />
		</form:form>
		
		<input type="checkbox" name="rememberMe">Remeber me<br>

		<br> <a href="<c:url value='/register' />">New Student?
			Register here...</a>
	</div>
</body>
</html>

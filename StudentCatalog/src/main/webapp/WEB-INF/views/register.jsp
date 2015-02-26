<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
body {
	background-color: #B8E6E6;
}
</style>
<title>Register</title>
</head>
<body>
	<jsp:include page="/WEB-INF/views/header.jsp" />
	<div align="center" style="margin-top: 100px">
		<c:url var="registerAction" value="/user/register"></c:url>

		<form:form action="${registerAction}" commandName="userData"
			method="post">

			<form:label path="firstName">
				<spring:message text="First name:" />
			</form:label>
			<form:input pattern=".{2,}" required="required"
				title="2 characters minimum" path="firstName" />
			<br>
			<br>

			<form:label path="lastName">
				<spring:message text="Last name:" />
			</form:label>
			<form:input pattern=".{2,}" required="required"
				title="3 characters minimum" path="lastName" />
			<br>
			<br>

			<form:label path="username">
				<spring:message text="Username:" />
			</form:label>
			<form:input pattern=".{5,}" required="required"
				title="5 characters minimum" path="username" />
			<br>
			<br>

			<form:label path="password">
				<spring:message text="Password: &nbsp" />
			</form:label>
			<form:input pattern="[A-Z][0-9a-zA-Z]{5,}" type="password"
				title="First letter must be uppercase and password must contain at least one digit, 5 characters minimum"
				required="required" path="password" />

			<br>
			<br>
			<br>

			<input type="submit" value="<spring:message text="Register"/>" />
		</form:form>

		<br> <a href="<c:url value='/login' />">Go back to login
			page...</a>
	</div>


</body>
</html>
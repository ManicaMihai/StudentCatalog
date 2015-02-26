<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<html>
<head>
<title>Teacher Page</title>
<style type="text/css">
body {
	text-align: center;
}

.tg {
	border-collapse: collapse;
	border-spacing: 0;
	border-color: #ccc;
	text-align: center;
}

.tg td {
	font-family: Arial, sans-serif;
	font-size: 14px;
	padding: 10px 5px;
	border-style: solid;
	border-width: 1px;
	overflow: hidden;
	word-break: normal;
	border-color: #ccc;
	color: #333;
	background-color: #fff;
}

.tg th {
	font-family: Arial, sans-serif;
	font-size: 14px;
	font-weight: normal;
	padding: 10px 5px;
	border-style: solid;
	border-width: 1px;
	overflow: hidden;
	word-break: normal;
	border-color: #ccc;
	color: #333;
	background-color: #f0f0f0;
}

.tg .tg-4eph {
	background-color: #f9f9f9
}
body {
	background-color: #B8E6E6;
}
</style>
</head>
<body>
	<jsp:include page="/WEB-INF/views/header.jsp" />

	<input style="position: fixed; top: 0px; right: 0px;" type="button"
		value="Logout"
		onclick="location.href = 'http://localhost:8080/StudentCatalog/login';" />
	<div align="center">
		<h1>Add a Grade</h1>

		<c:url var="addAction" value="/grade/add"></c:url>

		<form:form action="${addAction}" commandName="grade">
			<table>
				<c:if test="${!empty grade.studentId}">
					<tr>
						<td><form:label path="id">
								<spring:message text="ID" />
							</form:label></td>
						<td><form:input path="id" readonly="true" size="8"
								disabled="true" /> <form:hidden path="id" /></td>
					</tr>
				</c:if>
				<c:if test="${empty person.name}">
					<form:hidden path="id" value="0" />
				</c:if>
				<tr>
					<td><form:label path="studentId">
							<spring:message text="Student ID:" />
						</form:label></td>
					<td><form:input type="number" min="1" required="required"
							path="studentId" /></td>
				</tr>
				<tr>
					<td><form:label path="courseName">
							<spring:message text="Course Name:" />
						</form:label></td>
					<td><form:input required="required" pattern=".{2,}"
							title="2 characters minimum" path="courseName" /></td>
				</tr>
				<tr>
					<td><form:label path="grade">
							<spring:message text="Grade:" />
						</form:label></td>
					<td><form:input type="number" min="1" max="10"
							required="required" path="grade" /></td>
				</tr>
				<tr>
					<td colspan="2"><c:if test="${!empty grade.studentId}">
							<input type="submit" value="<spring:message text="Edit Grade"/>" />
						</c:if> <c:if test="${empty grade.studentId}">
							<input type="submit" value="<spring:message text="Add Grade"/>" />
						</c:if></td>
				</tr>
			</table>
		</form:form>
		<br> <input type="button" value="Get students name"
			onclick="location.href = 'http://localhost:8080/StudentCatalog/students';" />

		<h3>Grades List</h3>
		<c:if test="${!empty listGrades}">
			<table class="tg">
				<tr>
					<th width="80">Grade ID</th>
					<th width="80">Student ID</th>
					<th width="120">Course Name</th>
					<th width="80">Grade</th>
					<th width="60">Edit</th>
					<th width="60">Delete</th>
					<th width="200">Get all grades from this student</th>
				</tr>
				<c:forEach items="${listGrades}" var="grade">
					<tr>
						<td>${grade.id}</td>
						<td>${grade.studentId}</td>
						<td>${grade.courseName}</td>
						<td>${grade.grade}</td>
						<td><a href="<c:url value='/edit/${grade.id}' />">Edit</a></td>
						<td><a href="<c:url value='/remove/${grade.id}' />">Delete</a></td>
						<td><a href="<c:url value='/grades/${grade.studentId}' />">Get
								all grades from this student</a></td>
					</tr>
				</c:forEach>
			</table>
			<br>
			<a href="<c:url value='/grades' />">Get grades from all students</a>
		</c:if>

	</div>
</body>
</html>

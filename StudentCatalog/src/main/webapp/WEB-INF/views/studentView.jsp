<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<html>
<head>
<title>Student Page</title>
<style type="text/css">
.tg {
	border-collapse: collapse;
	border-spacing: 0;
	border-color: #ccc;
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
		<h3>Grades List</h3>
		<c:if test="${!empty listGrades}">
			<table class="tg">
				<tr>
					<th width="80">Grade ID</th>
					<th width="120">Course Name</th>
					<th width="80">Grade</th>
				</tr>
				<c:forEach items="${listGrades}" var="grade">
					<tr>
						<td>${grade.id}</td>
						<td>${grade.courseName}</td>
						<td>${grade.grade}</td>
					</tr>
				</c:forEach>
			</table>
		</c:if>

		<c:if test="${empty listGrades}">
			<b> There are no grades.</b>
		</c:if>
	</div>

</body>
</html>
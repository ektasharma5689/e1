<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Plans</title>
<style type="text/css">
h1 {
	color: blue;
}

body {
	background-color: skyblue;
}
</style>
</head>
<body>
	<div align="center">
		<h1>All Plan Details</h1>
		<table border=1px>
			<tr>
				<th colspan=14>Plans</th>
			</tr>
			<tr>
				<th>Plan ID</th>
				<th>Plan Name</th>
				<th>Plan Circle</th>
				<th>Monthly Rental</th>
				<th>Free Internet Data Usage Units</th>
				<th>Free Local Calls</th>
				<th>Free Local SMS</th>
				<th>Free STD Calls</th>
				<th>Free STD SMS</th>
				<th>Internet Data Usage Rate</th>
				<th>Local Call Rate</th>
				<th>Local SMS Rate</th>
				<th>STD Call Rate</th>
				<th>STD SMS Rate</th>
			</tr>
			<c:forEach var="plan" items="${plans}">
				<tr>
					<td><c:out value="${plan.planID}" /></td>
					<td><c:out value="${plan.planName}" /></td>
					<td><c:out value="${plan.planCircle}" /></td>
					<td><c:out value="${plan.monthlyRental}" /></td>
					<td><c:out value="${plan.freeInternetDataUsageUnits}" /></td>
					<td><c:out value="${plan.freeLocalCalls}" /></td>
					<td><c:out value="${plan.freeLocalSMS}" /></td>
					<td><c:out value="${plan.freeStdCalls}" /></td>
					<td><c:out value="${plan.freeStdSMS}" /></td>
					<td><c:out value="${plan.internetDataUsageRate}" /></td>
					<td><c:out value="${plan.localCallRate}" /></td>
					<td><c:out value="${plan.localSMSRate}" /></td>
					<td><c:out value="${plan.stdCallRate}" /></td>
					<td><c:out value="${plan.stdSMSRate}" /></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
<footer>
<div align="center">
	<a href="home">Return to home page</a>
</div>
</footer>
</html>
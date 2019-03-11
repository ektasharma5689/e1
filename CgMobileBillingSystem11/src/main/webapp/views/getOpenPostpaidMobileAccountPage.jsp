<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Registration</title>
<style>
h1 {
	color: blue;
}

body {
	background-color: skyblue;
}

.error {
	color: red;
	font-weight: bold;
}
</style>
</head>
<body>
	<div align="center">
		<h1>Enter Customer Details</h1>
		<form action="OpenPostpaidMobileAccount" method="post">
			<table>
				<tr>
					<td>Customer ID:</td>
					<td><input type="text" name="customerID" size="25" /></td>
				</tr>
				<tr>
					<td>Plan ID:</td>
					<td><input type="text" name="planID" size="25" /></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="Submit" name="submit" value="Submit" /></td>
				</tr>
			</table>
		</form>
	</div>
	<br/>
	<br/>
	<div align="center">
		<table border=1px >
			<tr>
				<th colspan=14>Plans</th>
			</tr>
			<tr>
				<th>Plan ID</th>
				<th>Plan Name</th>
				<th>Plan Circle</th>
				<th>Monthly <br/>Rental<br/>(INR)</th>
				<th>Free <br/>Internet Data <br/>Usage Units<br/>(MB)</th>
				<th>Free <br/>Local <br/>Calls<br/>(minutes)</th>
				<th>Free <br/>Local <br/>SMS</th>
				<th>Free <br/>STD <br/>Calls<br/>(minutes)</th>
				<th>Free <br/>STD <br/>SMS</th>
				<th>Internet Data <br/>Usage Rate<br/>(Rs./MB)</th>
				<th>Local <br/>Call <br/>Rate<br/>(Rs./minute)</th>
				<th>Local <br/>SMS <br/>Rate<br/>(Rs./SMS)</th>
				<th>STD <br/>Call <br/>Rate<br/>(Rs./minute)</th>
				<th>STD <br/>SMS <br/>Rate<br/>(Rs./SMS)</th>
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
<br/>
<div align="center">
	<a href="customer">Return to customer page</a>
</div>
</footer>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mobile Bill</title>
<style>
h1 {
	color: blue;
}

body {
	background-color: skyblue;
}
#success{
	color:green;
}
.error {
	color: red;
	font-weight: bold;
}
</style>
</head>
<body>
	<form action="ChangePlan" method="post">
		<div align="center">
			<h1>Enter Details</h1>
			<table>
				<tr>
					<th>Customer ID</th>
					<td><input type="number" placeholder="Enter Customer Id"
						name="customerID" required /></td>
				</tr>
				<tr>
					<th>Mobile Number</th>
					<td><input type="number" placeholder="Enter Mobile Number"
						name="mobileNo" required /></td>
				</tr>
				<tr>
					<th>Plan ID</th>
					<td><input type="number" placeholder="Enter Plan ID"
						name="planID" required /></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Proceed" /></td>
				</tr>
			</table>
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
		</form>
		<div align="center" id="success">
			<h3>${successMessage}</h3>
		</div>
</body>
<footer>
<br/>
	<div align="center">
		<a href="customer">Return to customer page</a>
	</div>
</footer>
</html>
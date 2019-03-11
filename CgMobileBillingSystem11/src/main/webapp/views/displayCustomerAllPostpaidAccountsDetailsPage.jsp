<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Post-Paid Accounts</title>
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
		<h1>All Post-Paid Accounts</h1>
		<table border=1px>
			<tr>
				<th colspan=23>Account Details</th>
			</tr>
			<tr><th rowspan=2>Mobile Number</th><!-- <th colspan=8>Customer Details</th> --><th colspan=14>Plan Details</th></tr>
			<tr>
				
				<!-- <th>Customer Id</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Date of Birth</th>
				<th>Email Id</th>
				<th>City</th>
				<th>PIN Code</th>
				<th>State</th> -->
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
			<c:forEach var="postpaidAccount" items="${postpaidAccounts}">
				<tr>
					<td><c:out value="${postpaidAccount.mobileNo}" /></td><%-- 
					<td><c:out value="${postpaidAccount.customer.customerId}" /></td>
					<td><c:out value="${postpaidAccount.customer.firstName}" /></td>
					<td><c:out value="${postpaidAccount.customer.lastName}" /></td>
					<td><c:out value="${postpaidAccount.customer.dateOfBirth}" /></td>
					<td><c:out value="${postpaidAccount.customer.emailID}" /></td>
					<td><c:out value="${postpaidAccount.customer.address.city}" /></td>
					<td><c:out value="${postpaidAccount.customer.address.pinCode}" /></td>
					<td><c:out value="${postpaidAccount.customer.address.state}" /></td> --%>
					<td><c:out value="${postpaidAccount.plan.planID}" /></td>
					<td><c:out value="${postpaidAccount.plan.planName}" /></td>
					<td><c:out value="${postpaidAccount.plan.planCircle}" /></td>
					<td><c:out value="${postpaidAccount.plan.monthlyRental}" /></td>
					<td><c:out value="${postpaidAccount.plan.freeInternetDataUsageUnits}" /></td>
					<td><c:out value="${postpaidAccount.plan.freeLocalCalls}" /></td>
					<td><c:out value="${postpaidAccount.plan.freeLocalSMS}" /></td>
					<td><c:out value="${postpaidAccount.plan.freeStdCalls}" /></td>
					<td><c:out value="${postpaidAccount.plan.freeStdSMS}" /></td>
					<td><c:out value="${postpaidAccount.plan.internetDataUsageRate}" /></td>
					<td><c:out value="${postpaidAccount.plan.localCallRate}" /></td>
					<td><c:out value="${postpaidAccount.plan.localSMSRate}" /></td>
					<td><c:out value="${postpaidAccount.plan.stdCallRate}" /></td>
					<td><c:out value="${postpaidAccount.plan.stdSMSRate}" /></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>
<footer>
<div align="center">
	<a href="customer">Return to customer page</a>
</div>
</footer>
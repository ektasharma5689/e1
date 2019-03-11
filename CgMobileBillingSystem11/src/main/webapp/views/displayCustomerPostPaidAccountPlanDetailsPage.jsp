<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.cg.mobilebilling.beans.Customer"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Postpaid Plan Details</title>
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
		<h1>Your Plan  Details </h1>
		<table border=1px>
			<tr>
				<th  colspan=2>Postpaid Plan Details</th>
			</tr>
			<tr>
				<td>Plan ID</td>
				<td>${plan.planID}</td>
			</tr>
			<tr>
				<td>Plan Name</td>
				<td>${plan.planName}</td>
			</tr>
			<tr>
				<td>Plan Circle</td>
				<td>${plan.planCircle}</td>
			</tr>
			<tr>
				<td>Monthly Rental</td>
				<td>Rs. ${plan.monthlyRental}</td>
			</tr>

			<tr>
				<td>Free Internet Data Usage Units</td>
				<td>${plan.freeInternetDataUsageUnits} MB</td>
			</tr>
			<tr>
				<td>Free Local Calls</td>
				<td>${plan.freeLocalCalls} minutes</td>
			</tr>
			<tr>
				<td>Free Local SMS</td>
				<td>${plan.freeLocalSMS}</td>
			</tr>
					<tr>
				<td>Free STD Calls</td>
				<td>${plan.freeStdCalls} minutes</td>
			</tr>
					<tr>
				<td>Free STD SMS</td>
				<td>${plan.freeStdSMS}</td>
			</tr>
					<tr>
				<td>Internet Data Usage Rate</td>
				<td>Rs. ${plan.internetDataUsageRate}/MB</td>
			</tr>
					<tr>
				<td>Local Call Rate</td>
				<td>Rs. ${plan.localCallRate}/minute</td>
			</tr>
			<tr>
				<td>Local SMS Rate</td>
				<td>Rs. ${plan.localSMSRate}</td>
			</tr>
			<tr>
				<td>STD Call Rate</td>
				<td>Rs. ${plan.stdCallRate}/minute</td>
			</tr>
			<tr>
				<td>STD SMS Rate</td>
				<td>Rs. ${plan.stdSMSRate}</td>
			</tr>
		</table>
	</div>
</body>
<footer>
<div align="center">
	<a href="customer">Return to customer page</a>
</div>
</footer>
</html>
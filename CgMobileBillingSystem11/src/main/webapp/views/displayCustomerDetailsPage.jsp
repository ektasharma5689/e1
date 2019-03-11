<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.cg.mobilebilling.beans.Customer"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Details</title>
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
		<h1>Customer details for customerId:
			${customer.customerID}</h1>
		<table border=1px>
			<tr>
				<th  colspan=2>Customer Details</th>
			</tr>
			<tr>
				<td>First Name</td>
				<td>${customer.firstName}</td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td>${customer.lastName}</td>
			</tr>
			<tr>
				<td>Date of Birth</td>
				<td>${customer.dateOfBirth}</td>
			</tr>
			<tr>
				<td>Email Id</td>
				<td>${customer.emailID}</td>
			</tr>
			<tr>
				<th  colspan=2>Address</th>
			</tr>
			<tr>
				<td>City</td>
				<td>${customer.billingAddress.city}</td>
			</tr>
			<tr>
				<td>PIN Code</td>
				<td>${customer.billingAddress.pinCode}</td>
			</tr>
			<tr>
				<td>State</td>
				<td>${customer.billingAddress.state}</td>
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
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Customers</title>
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
		<h1>All Customers Details</h1>
		<table border=1px>
			<tr>
				<th colspan=14>Customers Details</th>
			</tr>
			<tr>
				<th>Customer Id</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Date of Birth</th>
				<th>Email Id</th>
				<th>City</th>
				<th>PIN Code</th>
				<th>State</th>
			</tr>
			<c:forEach var="customer" items="${customers}">
				<tr>
					<td><c:out value="${customer.customerID}" /></td>
					<td><c:out value="${customer.firstName}" /></td>
					<td><c:out value="${customer.lastName}" /></td>
					<td><c:out value="${customer.dateOfBirth}" /></td>
					<td><c:out value="${customer.emailID}" /></td>
					<td><c:out value="${customer.billingAddress.city}" /></td>
					<td><c:out value="${customer.billingAddress.pinCode}" /></td>
					<td><c:out value="${customer.billingAddress.state}" /></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
<footer>
<div align="center">
	<a href="admin">Return to admin page</a>
</div>
</footer>
</html>
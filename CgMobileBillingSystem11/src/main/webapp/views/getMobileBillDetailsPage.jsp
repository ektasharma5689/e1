<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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

.error {
	color: red;
	font-weight: bold;
}
</style>
</head>
<body>
	<form action="displayMonthlyBill" method="post">
		<div align="center">
			<h1>Enter Details</h1>
			<table>
				<tr>
					<th>Customer Id</th>
					<td><input type="number" placeholder="Enter Customer Id"
						name="customerID" required /></td>
				</tr>
				<tr>
					<th>Mobile Number</th>
					<td><input type="number" placeholder="Enter Mobile Number"
						name="mobileNo" required /></td>
				</tr>
				<tr>
					<th>Bill Month</th>
					<td><input type="text" placeholder="Enter Bill Month"
						name="billMonth" required /></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Proceed" /></td>
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
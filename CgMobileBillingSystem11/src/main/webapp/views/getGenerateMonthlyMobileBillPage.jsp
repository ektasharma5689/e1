<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
<body align=center>
	<div align=center>
		<h1>Enter Customer Details</h1>
		<form action="GenerateMonthlyMobileBill" method="post">
			<table>
				<tr>
					<td>Customer ID:</td>
					<td><input type="text" name="customerID" size="25" /></td>
				</tr>
				<tr>
					<td>Mobile Number:</td>
					<td><input type="text" name="mobileNo" size="25" /></td>
				</tr>
				<tr>
					<td>Bill Month:</td>
					<td><input type="text" name="billMonth" size="25" /></td>
				</tr>
				<tr>
					<td>Number of local SMS:</td>
					<td><input type="text" name="noOfLocalSMS" size="25" /></td>
				</tr>
				<tr>
					<td>Number of local calls:</td>
					<td><input type="text" name="noOfLocalCalls" size="25" /></td>
				</tr>
				<tr>
					<td>Number of STD SMS:</td>
					<td><input type="text" name="noOfStdSMS" size="25" /></td>
				</tr>
				<tr>
					<td>Number of STD calls:</td>
					<td><input type="text" name="noOfStdCalls" size="25" /></td>
				</tr>
				<tr>
					<td>Internet Data Usage Units:</td>
					<td><input type="text" name="internetDataUsageUnits" size="25" /></td>
				</tr>
					<td></td>
					<td><input type="Submit" name="submit" value="Submit" /></td>
				</tr>
			</table>
		</form>
	</div>
</body>
<footer>
<div align="center">
	<a href="customer">Return to customer page</a>
</div>
</footer>
</html>
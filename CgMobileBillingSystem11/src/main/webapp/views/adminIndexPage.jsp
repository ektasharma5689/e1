<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Capgemini</title>
<style type="text/css">
h1 {
	color: blue;
}

h4 {
	color: green;
}

body {
	background-color: skyblue;
}

#errorMessage {
	color: red;
	font-weight: bold;
}
</style>
</head>
<body>
	<div align="center">
		<h1>Welcome to Postpaid Mobile Billing System</h1>
		<table cellpadding=5 cellspacing=5>
			<tr>
				<td><a href="allCustomerDetails"><input type="button"
						value="View All Customers"></a></td>

				<td><a href="deletePostpaidAccount"><input type="button"
						value="Delete Postpaid Account"></a></td>

				<td><a href="deleteCustomer"><input type="button"
						value="Delete Customer"></a></td>
			</tr>
		</table>
	</div>
	<div align="center">
		<h4>${message}</h4>
	</div>
	<div align="center" id="errorMessage">
		<h3>${errorMessage}</h3>
	</div>
</body>
<div align="center">
	<a href="home">Return to home page</a>
</div>
</html>
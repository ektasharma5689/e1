<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//Dth HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dth">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Success</title>
<style type="text/css">
h1 {
	color: blue;
}

h3 {
	color: green;
}

body {
	background-color: skyblue;
}
</style>
</head>
<body>
	<div align="center">
		<h1>Monthly Bill</h1>
		<table>
			<tr>
				<th>Total Bill Amount(in INR):</th>
				<th>${totalBillAmount}</th>
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
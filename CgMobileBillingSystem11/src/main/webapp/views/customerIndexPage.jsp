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
background-color: navy;
}

#success {
	color: green;
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
				<td><a href="register"><input type="button"
						value="Register New Customer"></a></td>

				<td><a href="openPostpaidMobileAccount"><input
						type="button" value="Open Post-Paid Mobile Account"></a></td>

				<td><a href="generateMonthlyMobileBill"><input
						type="button" value="Generate Monthly Bill"></a></td>
			</tr>
			<tr>
				<td><a href="customerDetails"><input type="button"
						value="View Customer"></a></td>

				<td><a href="customerAllPostpaidAccountsDetails"><input
						type="button" value="View Customer All Post-Paid Accounts"></a></td>

				<td><a href="mobileBillDetails"><input type="button"
						value="View Mobile Bill"></a></td>
			</tr>
			<tr>
				<td><a href="customerPostPaidAccountAllBillDetails"><input
						type="button" value="View Cutomer All Mobile Bills"></a></td>

				<td><a href="changePlan"><input type="button"
						value="Change Plan"></a></td>

				<td><a href="customerPostPaidAccountPlanDetails"><input
						type="button" value="View Customer Post Paid Account Plan Details"></a></td>

			</tr>
		</table>
	</div>
	<div align="center">
		<h4>${message}</h4>
	</div>
	<div align="center" id="errorMessage">
		<h3>${errorMessage}</h3>
	</div>
	<div align="center" id="success">
		<h3>${successMessage}</h3>
	</div>
</body>
<div align="center">
	<a href="home">Return to home page</a>
</div>
</html>
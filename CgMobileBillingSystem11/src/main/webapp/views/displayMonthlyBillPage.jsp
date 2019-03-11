<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//Dth HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dth">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bill</title>
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
		<h1>Monthly Bill Details</h1>
		<table border=1px>
			<tr>
				<td>Bill ID</td>
				<td>${bill.billID}</td>
			</tr>
			<tr>
				<td>Bill Month</td>
				<td>${bill.billMonth}</td>
			</tr>
			<%-- <tr>
				<td>Customer ID</td>
				<td>${postpaidAccount.customer.customerID}</td>
			</tr>
			<tr>
				<td>Customer Name</td>
				<td>${postpaidAccount.customer.firstName} ${postpaidAccount.customer.lastName}</td>
			</tr>
			<tr>
				<td>Mobile Number</td>
				<td>${postpaidAccount.mobileNo}</td>
			</tr> --%>
			<tr>
				<td>Internet Data Usage Units</td>
				<td>${bill.internetDataUsageUnits}</td>
			</tr>
			<tr>
				<td>Internet Data Usage Amount</td>
				<td>${bill.internetDataUsageAmount}</td>
			</tr>
			<tr>
				<td>Number Of Local Calls</td>
				<td>${bill.noOfLocalCalls}</td>
			</tr>
			<tr>
				<td>Local Call Amount</td>
				<td>${bill.localCallAmount}</td>
			</tr>
			<tr>
				<td>Number Of Std Calls</td>
				<td>${bill.noOfStdCalls}</td>
			</tr>
			<tr>
				<td>Std Call Amount</td>
				<td>${bill.stdCallAmount}</td>
			</tr>
			<tr>
				<td>Number Of Local SMS</td>
				<td>${bill.noOfLocalSMS}</td>
			</tr>
			<tr>
				<td>Local SMS Amount</td>
				<td>${bill.localSMSAmount}</td>
			</tr>
			<tr>
				<td>Number Of Std SMS</td>
				<td>${bill.noOfStdSMS}</td>
			</tr>
			<tr>
				<td>Std SMS Amount</td>
				<td>${bill.stdSMSAmount}</td>
			</tr>
			<tr>
				<td>Service Tax</td>
				<td>${bill.servicesTax}</td>
			</tr>
			<tr>
				<td>Vat</td>
				<td>${bill.vat}</td>
			</tr>
			<tr>
				<td>Total Bill Amount(in INR)</td>
				<td>${bill.totalBillAmount}</td>
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
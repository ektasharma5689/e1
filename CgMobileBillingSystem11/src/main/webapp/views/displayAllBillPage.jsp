<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Bills</title>
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
		<h1>Postpaid Account All Bills</h1>
		<table style="border: 1px">
		
			<tr><th colspan=15>Bill Details</th></tr>
			<tr>
				<th>Bill ID</th>
				<th>Bill Month</th>
				<th>Internet Data Usage Units</th>
				<th>Internet Data Usage Amount</th>
				<th>Number Of Local Calls</th>
				<th>Local Call Amount</th>
				<th>Number Of Std Calls</th>
				<th>Std Call Amount</th>
				<th>Number Of Local SMS</th>
				<th>Local SMS Amount</th>
				<th>Number Of Std SMS</th>
				<th>Std SMS Amount</th>
				<th>Service Tax</th>
				<th>Vat</th>
				<th>Total Bill Amount(in INR)</th>
			</tr>
			<c:forEach var="bill" items="${bills}">
				<tr>
					<td><c:out value="${bill.billID}" /></td>
					<td><c:out value="${bill.billMonth}" /></td>
					<td><c:out value="${bill.internetDataUsageUnits}" /></td>
					<td><c:out value="${bill.internetDataUsageAmount}" /></td>
					<td><c:out value="${bill.noOfLocalCalls}" /></td>
					<td><c:out value="${bill.localCallAmount}" /></td>
					<td><c:out value="${bill.noOfStdCalls}" /></td>
					<td><c:out value="${bill.stdCallAmount}" /></td>
					<td><c:out value="${bill.noOfLocalSMS}" /></td>
					<td><c:out value="${bill.localSMSAmount}" /></td>
					<td><c:out value="${bill.noOfStdSMS}" /></td>
					<td><c:out value="${bill.stdSMSAmount}" /></td>
					<td><c:out value="${bill.servicesTax}" /></td>
					<td><c:out value="${bill.vat}" /></td>
					<td><c:out value="${bill.totalBillAmount}" /></td>
				</tr>
			</c:forEach>
		</table>
	</div>
<div>
	<a href="customer">Return to customer page</a>
</div>
</body>
</html>
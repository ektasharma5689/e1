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
#errorMessage {
	color: red;
	font-weight: bold;
}
</style>
</head>
<body align=center>
	<div align=center>
		<h1>Enter Customer Details</h1>
		<table>
			<form:form action="registerCustomer" method="post"
				modelAttribute="customer" >
				<tr>
					<td>First Name:</td>
					<td><form:input path="firstName" size="16" /></td>
					<td><form:errors path="firstName" cssClass="error" /></td>
				</tr>
				<tr>
					<td>Last Name:</td>
					<td><form:input path="lastName" size="16" /></td>
					<td><form:errors path="lastName" cssClass="error" /></td>
				</tr>
				<tr>
					<td>Email Id:</td>
					<td><form:input path="emailID" size="16" /></td>
					<td><form:errors path="emailID" cssClass="error" /></td>
				</tr>
				<tr>
					<td>Date of Birth:</td>
					<td><form:input path="dateOfBirth"  type="date" size="16" /></td>
					<td><form:errors path="dateOfBirth" cssClass="error" /></td>
				</tr>
				<tr>
					<td>City:</td>
					<td><form:input path="billingAddress.city" size="16" /></td>
					<td><form:errors path="billingAddress.city" cssClass="error" /></td>
				</tr>
				<tr>
					<td>PIN Code:</td>
					<td><form:input path="billingAddress.pinCode" size="16" /></td>
					<td><form:errors path="billingAddress.pinCode"
							cssClass="error" /></td>
				</tr>
				<tr>
					<td>State:</td>
					<td><form:input path="billingAddress.state" size="16" /></td>
					<td><form:errors path="billingAddress.state" cssClass="error" /></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="Submit" name="submit" value="Submit">
					</td>
					<td></td>
				</tr>
			</form:form>
		</table>
	</div>
	<div align="center" id="errorMessage">
			<h3>${errorMessage}</h3>
		</div>
</body>
<footer>
<div align="center">
	<a href="customer">Return to customer page</a>
</div>
</footer>
</html>
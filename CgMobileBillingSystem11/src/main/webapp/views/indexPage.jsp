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
	/* background-image:url("2.jpg"); */
	background-color: skyblue;
	/* font-family: cursive; */
}
input{
background-color:aqua;}
input:hover{
background-color: red;
}
#errorMessage {
	color: red;
	font-weight: bold;
}
</style>
</head>
<body >
	<div align="center">
		<table cellpadding=5 cellspacing=5>
			<tr>
				<font><h1>Welcome to Postpaid Mobile Billing System</h1></font>
			</tr>
			<tr>
				<td><a href=allPlanDetails><input type="button" value="Plan Details"></a></td>
				<td><a href=customer><input type="button" value="Customer"></a></td>
				<td><a href=admin><input type="button" value="Admin"></a></td>
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
</html>
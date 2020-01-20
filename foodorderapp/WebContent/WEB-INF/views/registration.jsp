<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register a new customer</title>
</head>
<body>
	<div align="center">
		<h3>Are you a new customer? Tell us about yourself please!</h3>
		<form:form action="register" method="post" modelAttribute="customer">
			<table>
			
				<tr>
					<td>First Name</td>
					<td><form:input path="firstName" /></td>
				</tr>
				
				<tr>
					<td>Last Name</td>
					<td><form:input path="lastName" /></td>
				</tr>
			
				<tr>
					<td>Email</td>
					<td><form:input path="email" /></td>
				</tr>

				<tr>
					<td>Password</td>
					<td><form:password path="pass" /></td>
				</tr>
				
				<tr>
					<td colspan="2"><h3>Where do you want your food to be delivered?</h3></td>
				</tr>
				
				<tr>
					<td>Street No</td>
					<td><form:input path="address.streetNumber" /></td>
				</tr>
				
				<tr>
					<td>Street Name</td>
					<td><form:input path="address.streetName" /></td>
				</tr>
				
				<tr>
					<td>Apartment</td>
					<td><form:input path="address.apt" /></td>
				</tr>
				
				<tr>
					<td>Postal Code</td>
					<td><form:input path="address.postalCode" /></td>
				</tr>
					
				<tr>
					<td colspan="2"><input type="submit" value="Register"></td>
				</tr>
			</table>

		</form:form>
	</div>
</body>
</html>
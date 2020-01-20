<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login page</title>
</head>
<body>
	<div align="center">
		Log in
		<form:form action="login" method="post" modelAttribute="customer">
			<table>
				<tr>
					<td>Email</td>
					<td><form:input path="email" value="${email}"/></td>
				</tr>

				<tr>
					<td>Password</td>
					<td><form:password path="pass" value="${pass}"/></td>
				</tr>


				<tr>
					<td colspan="2"><input type="submit" value="Log in"></td>
				</tr>
			</table>

		</form:form>
	</div>
</body>
</html>
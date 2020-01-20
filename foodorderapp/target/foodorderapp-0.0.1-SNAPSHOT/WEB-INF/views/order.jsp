<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Order Page</title>
</head>
<body>
<h2 align="center">Make your order please</h2>
<div align="left">
	<h3>Available products</h3>
	<table>
			<tr>
				<th>Name</th>
				<th>Size</th>
				<th>Price</th>
			</tr>

			<c:forEach var="product" items="${productList}">
				<tr>
					<td><c:out value="${product.name}"></c:out></td>
					<td><c:out value="${product.size}"></c:out></td>
					<td><c:out value="${product.price}"></c:out></td>
					<td><a href="additem?itemId=${product.id}">Add to order</a></td>
				</tr>
			</c:forEach>

		</table>
</div>
<div align="center">

</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Product Management System</h1>
	<table border="2">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Quantity</th>
			<th>Price</th>
			<th>Actions</th>
		</tr>
		<c:forEach var="prod" items="${plist}">
			<tr>
				<td>${prod.pid}</td>
				<td>${prod.pname}</td>
				<td>${prod.qty}</td>
				<td>${prod.price}</td>
				
				<td><a href="deleteProduct/${prod.pid}">Delete</a>/<a href="editProduct/${prod.pid}">Edit</a></td>
			</tr>
		</c:forEach>
	</table>
	<a href="addproduct">Add Product</a>
</body>
</html>
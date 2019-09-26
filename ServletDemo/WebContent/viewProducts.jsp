<%@page import="com.bv.model.Products"%>
<%@page import="java.util.List"%>
<%@page import="com.bv.handler.ProductHandler"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Products</title>
</head>
<body>
	<h1>All Products</h1>
	<a href="addProducts.html">add product</a>
	<% List<Products> prodList = ProductHandler.getAllProducts(); %>
	
	<table border="1">
		<tr>
			<th>Product Id</th>
			<th>Product Name</th>
			<th>Manufacturer Name</th>
			<th>Price</th>
			<th>Date</th>
			<th>update</th>
			<th>delete</th>
		</tr>
			
			<%for(Products product: prodList){ %>
			<tr>
				<td><%=product.getId() %></td>
				<td><%=product.getProductname() %></td>
				<td><%=product.getManufacturername() %></td>
				<td><%=product.getPrice() %></td>
				<td><%=product.getManufracturingDate() %></td>
				<td><a href="updateProduct.jsp?id1=<%=product.getId()%> ">update</a></td>
				<td><a href="DeleteServlet?id=<%=product.getId()%> ">delete</a></td>
			</tr>
			<%} %>
	</table>
	<a href="LogoutServlet">logout</a>
</body>
</html>
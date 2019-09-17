<%@page import="com.bv.model.Products"%>
<%@page import="com.bv.handler.ProductHandler"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"
	integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu"
	crossorigin="anonymous">

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap-theme.min.css"
	integrity="sha384-6pzBo3FDv/PJ8r2KRkGHifhEocL+1X2rVCTTkUfGk7/0pbek5mMa1upzvWbrUbOZ"
	crossorigin="anonymous">

<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"
	integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd"
	crossorigin="anonymous"></script>
<meta charset="ISO-8859-1">
<title>Mobile Shop</title>
<%-- 	<%
		int id = Integer.parseInt(request.getParameter("id1"));
		Products product = ProductHandler.getProductById(id);
		System.out.println(product.getId()+" "+product.getProductname());
	%> --%>
</head>
	<%-- <form action="UpdateServlet">
		<table border="1">
			<tr>
				<td><input type="hidden" name="id" value="<%=product.getId()%>" /></td>

				<tr>
			<td>Product Name: <input type="text" name="productname"
					value= "<%=product.getProductname()%>" />
				</td>
			</tr><tr>
				<td>Manufacturer Name: <select name="manufacturername">
						<option value="oneplus">OnePlus</option>
						<option value="samsung">Samsung</option>
						<option value="nokia">Nokia</option>
				</select>
				</td>
			</tr>
			<tr>
				<td>Price<input type="number" name="price"
					value="<%=product.getPrice()%>"></td>
			</tr>
			<tr>
				<td><input type="submit" value="update"></td>
			</tr>
		</table>
	</form> --%>
	
	
	
	
	<%
		String pid = request.getParameter("id1");
		int id = Integer.parseInt(pid);
		Products products = ProductHandler.getProductById(id);
		System.out.println(products.getId()+" "+products.getProductname()+" "+products.getPrice());
	%>
<body>
	<h1>Update Products</h1>
	
	<form action="UpdateServlet">
		<table>
			<tr>
				<td></td>
				<td><input type='hidden' name="id"
					value="<%=products.getId()%>" /></td>
			</tr>
			<tr>
				<td>Product Name:</td>
				<td><input type="text" name="productname"
					value="<%=products.getProductname()%>" /></td>
			</tr>
			<tr>
				<td>Manufacturer Name: <select name="manufacturername"
					style="width: 150px">
						<option value="Samsung">Samsung</option>
						<option value="Oppo">Oppo</option>
						<option value="Vivo">Vivo</option>
						<option value="IPhone">IPhone</option>
						<option value="MI">MI</option>
						<option value="Others">Others</option>
				</select>
			<tr>
				<td>Price:</td>
				<td><input type="number" name="price"
					value="<%=products.getPrice()%>" /></td>
			</tr>
			<tr>
				<td><input type='submit' value='Update' /></td>
			</tr>
		</table>
	</form>
	
	<a href="viewProducts.jsp">View Products</a>
</body>
</html>
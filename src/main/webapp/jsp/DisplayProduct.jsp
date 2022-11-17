<%@page import="product.Product"%>
<%@page import="product.ProductRepository"%>
<%@page import="java.util.List"%>
<%@ page language="java" %>

<%
List<Product> prod = (List<Product>) request.getAttribute("productlist");
%>

<html>
	<head>
		<title>Menu</title>
	</head>
	<body>
		<h2>Menu</h2>
		<hr/>
		
		<%
		if(prod.isEmpty()){
		%>
			<b>SOLD OUT</b>
		<%
		}
		%>
		
		<table>
			<thead>
				<tr>
					<td>Product Number</td>
					<td>Product Name</td>
					<td>Description</td>
					<td>Price</td>
					<td>Quantity</td>
					<td>Category</td>
				</tr>
			</thead>
			<tbody>
				<%
				for(Product prods:prod){
				%>
					<form action="${pageContext.request.contextPath}/cartServlet?action=add" method="POST">
					<tr>
						<td><%= prods.getProductNumber()%></td>
						<td><%= prods.getProductName()%>  </td>
						<td><%= prods.getDescription()%>  </td>
						<td><%= prods.getPrice()%>        </td>
						<td><%= prods.getQuantity()%>     </td>
						<td><%= prods.getCategory()%>     </td>
						<td>
							<input type="hidden" name="prodNum" value="<%= prods.getProductNumber()%> ">						
							<input type="hidden" name="price" value="<%= prods.getPrice()%> ">
							<input type="hidden" name="quantity" value="<%= prods.getQuantity()%> ">
							<input type="submit" value="add to cart">		
						</td>
					</tr>				
					</form>
				<%
				}
				%>			
			</tbody>		
		</table>
		<hr/>
	</body>


</html>
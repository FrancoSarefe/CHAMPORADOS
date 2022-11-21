<%@page import="cart.CartItem"%>
<%@page import="cart.Cart"%>
<%@ page language="java" %>

<% 
Cart cart = (Cart) session.getAttribute("cart");
%>

<html>
	<head>
		<title>ChampCart</title>
	</head>
	
	<body>	
		<h2>Yor Cart</h2>
		<br/>
		<a href="./productServlet">Add More</a>
		<br/>
		<hr/>
		<%
		if(cart.countItems() == 0){
		%>
			<b>Your cart is empty</b>
		<%
		}
		%>
		
		<%
		if(cart.countItems() > 0){
		%>
			<table>
				<thead>
					<tr>
						<td>Product Number </td>
						<td>Cart Number </td>
						<td>Quantity </td>
						<td>Total Price </td>
						<td>Wallet Number </td>
					</tr>
				</thead>
				<tbody>
					<%
					for(CartItem item : cart.getCartAsList()){
					%>
						<tr>
							<td><%= item.getProductNumber()%></td>
							<td><%= item.getCartNumber()%></td>
							<td><%= item.getQuantity()%></td>
							<td><%= item.getTotalPrice()%></td>
							<td><%= item.getWalletNumber()%></td>
							<td>
							<form action="${pageContext.request.contextPath}/cartServlet?action=remove" method="POST">
								<input type="hidden" name="prodNum" value="<%= item.getProductNumber()%>">
								<input type="submit" name="remove" value="Remove to Cart">
							</form>
							
							</td>
						</tr>
					<%
					}
					%>
			</tbody>
			</table>	
		<%
		}
		%>
		<hr/>
		<b>Grand Total: <%= cart.getGrandTotal() %></b>
		<hr/>
			<form action="${pageContext.request.contextPath}/cartServlet?action=save" method="POST">
				<input type="submit" name="save" value="Save Cart">				
			</form>
	</body>




</html>

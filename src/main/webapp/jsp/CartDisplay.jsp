<%@page import="cart.Cart"%>
<%@page import="cart.CartItem"%>
<%@ page import="java.util.List" %>
<%@ page language="java" %>

<%
CartItem cartItem = (CartItem) session.getAttribute("cart");
%>

<html>
	<head>
		<title>Cart</title>
	</head>
	<body>
		<h2>User Cart</h2>
		<br/>
		<a href="./productServlet">Add more</a>
		<hr/>
		<%
		if(cartItem.countCartItems() == 0){
		%>
			<b>Cart is empty, but you can add something</b>
		<%
		}
		%>
		<%
		if(cartItem.countCartItems() > 0){
		%>
		<table>
			<thead>
				<tr>
					<td>Product Number</td>
					<td>Cart Number</td>
					<td>Quantity</td>
					<td>total Price</td>					
					<td>User Number</td>
				</tr>		
			</thead>
			<tbody>
				<%
				for(Cart prod: cartItem.getProductAsList()){
				%>
					<tr>
						<td><%= prod.getProductNumber()%></td>
						<td><%= prod.getCartNumber()%></td>
						<td><%= prod.getQuantity()%></td>
						<td><%= prod.getTotalPrice()%></td>					
						<td><%= prod.getUserNumber()%></td>
						<<td>
							<form action="./cartServlet?action=remove" method="POST">
								<input type="hidden" name="prodNum" value="<%= prod.getProductNumber()%>">
								<input type="submit" name="remove" value="remove item">
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
	</body>
</html>

<%@page import="cart.CartItem"%>
<%@page import="java.util.List"%>
<%@ page language="java" %>
<%
List<CartItem> cart = (List<CartItem>) request.getAttribute("cartDisplay");
%>

<html>
	<head>
		<title>Cart View</title>	
	</head>
	<body>
	<a href="./productServlet">Add Products</a>
	<hr/>
		<%
		if(cart.isEmpty()){
		%>
			<h1><b>Your personal cart is empty</b></h1>
		<%
		}
		%>
		
		<%
		if(!(cart.isEmpty())){
		%>
			<table>
				<thead>
					<tr>
						<td>Product Number</td>
						<td>Cart Number</td>
						<td>Quantity</td>
						<td>Total Price</td>
						<td>Wallet Number</td>
					</tr>
				</thead>
				<tbody>
					<%
					for(CartItem items: cart){
					%>
						<tr>
							<td><%= items.getProductNumber()%></td>
							<td><%= items.getCartNumber()%></td>
							<td><%= items.getQuantity()%></td>
							<td><%= items.getTotalPrice()%></td>
							<td><%= items.getWalletNumber()%></td>
							<td>
								<form action="${pageContext.request.contextPath}/cartServlet?action=delete" method="POST">
									<input type="hidden" name="Numb" value="<%= items.getProductNumber()%>">
									<input type="submit" value="delete">
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
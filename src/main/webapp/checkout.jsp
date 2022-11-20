<%@ page language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
	<head>
		<title>CHAMP Web Cafeteria</title>
	</head>
	<body>
		<h2>Checkout</h2>
		<hr/>
		<c:if test="${cartItems.size() == 0 }">
			<b>No cart items found!</b>
		</c:if>
		<c:if test="${cartItems.size() > 0 }">
		<!-- Display list of cart items -->
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
				<c:forEach var="cartItem" items="${cartItems}">
					<tr>
						<td> <c:out value="${cartItem.productNumber }"></c:out>
						<td> <c:out value="${cartItem.cartNumber }"></c:out>
						<td> <c:out value="${cartItem.quantity }"></c:out>
						<td> <c:out value="${cartItem.totalPrice }"></c:out>
						<td> <c:out value="${cartItem.walletNumber }"></c:out>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<br/>
		<b>Grand total: <c:out value="${grandTotal}"></c:out></b><br/>
		<b>Balance: <c:out value="${balanceAmount}"></c:out></b><br/>
		<c:if test="${!isBalanceEnough }">
			<b>Not enough balance to check out all items in the cart!</b><br/>
		</c:if>		
		<c:if test="${isBalanceEnough }">
			<form action="./checkout?action=checkout" method="POST">
			<!-- Dropdown for available rooms for delivery -->
			<select id="room" name="room" required>
				<option value="" disabled hidden selected>Select Room</option>
				<option value="Suite A">Suite A</option>
				<option value="Suite B">Suite B</option>
				<option value="Suite D">Suite D</option>
				<option value="Suite E">Suite E</option>
				<option value="Reception Area">Reception Area</option>
				<option value="Big Pantry">Big Pantry</option>
			</select>
			<br/>
			<input type="hidden" name="walletNumber" value="${walletNumber}">
			<input type="submit" value="Checkout">
		</form>
		</c:if>	
		</c:if>
	</body>
</html>
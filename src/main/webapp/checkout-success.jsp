<%@ page language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
	<head>
		<title>CHAMP Web Cafeteria</title>
	</head>
	<body>
		<h2>Checkout Successful</h2>
		<hr/>
		<h3>Cart Item Details</h3>
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
		<h3>Transaction Details</h3>
		<table>
			<thead>
				<tr>
					<td><b>ID</b></td>
					<td><b>Transaction Number</b></td>
					<td><b>Wallet Number</b></td>
					<td><b>Room</b></td>
					<td><b>Grand Total</b></td>
					<td><b>Date Created</b></td>
					<td><b>Status</b></td>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="transaction" items="${transactions }">
					<tr>
						<td> <c:out value="${transaction.id}"/> </td>
						<td> <c:out value="${transaction.transactionNumber}"/> </td>
						<td> <c:out value="${transaction.walletNumber}"/> </td>
						<td> <c:out value="${transaction.room}"/> </td>
						<td> <c:out value="${transaction.grandTotal}"/> </td>
						<td> <c:out value="${transaction.dateCreated}"/> </td>
						<td> <c:out value="${transaction.status}"/> </td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<br/>
		<b>Your remaining balance is: <c:out value="${remainingBalance}"/></b><br/>
	</body>
</html>
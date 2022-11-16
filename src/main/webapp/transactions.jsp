<%@page import="entity.TransactionEntity"%>
<%@ page language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.List"%>

<html>
	<head>
		<title>CHAMP Web Cafeteria</title>
	</head>
	<body>
		<h2>Transactions</h2>
		<hr/>
		<c:if test="${transactions.size() == 0}">
			<b>No transactions found</b>
		</c:if>
		<c:if test="${transactions.size() > 0}">
			<table>
				<thead>
					<tr>
						<td>ID</td>
						<td>Transaction Number</td>
						<td>Cart Number</td>
						<td>Room</td>
						<td>Grand Total</td>
						<td>Date Created</td>
						<td>Status</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="transaction" items="${transactions}">
							<tr>
								<td> <c:out value="${transaction.id}"/> </td>
								<td> <c:out value="${transaction.transactionNumber}"/> </td>
								<td> <c:out value="${transaction.cartNumber}"/> </td>
								<td> <c:out value="${transaction.room}"/> </td>
								<td> <c:out value="${transaction.grandTotal}"/> </td>
								<td> <c:out value="${transaction.dateCreated}"/> </td>
								<td> <c:out value="${transaction.status}"/> </td>
							</tr>
					</c:forEach>
				</tbody>
			</table>
			<hr/>
			<b>Update Status by ID</b>
			<br/>
			<form action="./transactions?action=updateStatus" method="POST">
				<!-- Insert dropdown list here for different status values -->
				<select id="status-update" name="status-update" required>
					<option value="" disabled hidden selected>Select Status Update</option>
					<option value="Pending">Pending</option>
					<option value="Processing">Processing</option>
					<option value="Cancelled">Cancelled</option>
					<option value="Complete">Completed</option>
				</select>
				<!-- Insert text box here to indicate ID -->
				<input type="text" id="selected-transaction" name="selected-transaction" placeholder="Indicate Transaction Number here..." required>
				<!-- Insert submit button for form -->
				<input type="submit" value="Update Status">
			</form>
		</c:if>
	</body>
</html>
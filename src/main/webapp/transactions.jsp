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
		</c:if>
	</body>
</html>
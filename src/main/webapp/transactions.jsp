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
					<c:forEach var="transaction" items="${transactions}">
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
			<div class="form-group">
				<b>Sort Transactions View</b><br/>
				<form action="./transactions?action=sort" method="POST">
					<select id="sort-filter" name="sort-filter" required>
						<option value="" disabled hidden selected>Select Sort Filter</option>
						<option value="id">ID</option>
						<option value="transaction-number">Transaction Number</option>
						<option value="wallet-number">Wallet Number</option>
					</select>
					<br/>
					<input type="hidden" name="operation" value="filter">
					<input type="submit" value="Sort View">
				</form>
			</div>
			<hr/>
			<div class="form-group">
				<b>Search Transactions</b>
				<br/>
				<form action="./transactions?action=search" method="POST">
					<select id="search-filter" name="search-filter" required>
						<option value="" disabled hidden selected>Select Search Filter</option>
						<option value="Wallet Number">Wallet Number</option>
						<option value="Transaction Number">Transaction Number</option>
					</select>
					<input type="text" id="search-parameter" name="search-parameter" placeholder="Search Parameter here..." required>
					<input type="hidden" name="operation" value="search">
					<br/>
					<input type="submit" value="Search">
				</form>
			</div>
			<hr/>
			<div class="form-group">
				<b>Update Status by Transaction Number</b>
				<br/>
				<form action="./transactions?action=updateStatus" method="POST">
					<select id="status-update" name="status-update" required>
						<option value="" disabled hidden selected>Select Status Update</option>
						<option value="Pending">Pending</option>
						<option value="Processing">Processing</option>
						<option value="Cancelled">Cancelled</option>
						<option value="Complete">Completed</option>
					</select>
					<input type="text" id="selected-transaction" name="selected-transaction" placeholder="Indicate Transaction Number here..." required>
					<br/>
					<input type="hidden" name="operation" value="update">
					<input type="submit" value="Update Status">
				</form>
			</div>
		</c:if>
		<div class="form-group">
				<b>Force Insert New Transaction</b>
				<br/>
				<form action="./transactions?action=insertTransaction" method="POST">
					<table>
						<thead>
							<tr>
								<td>Transaction Number</td>
								<td>Wallet Number</td>
								<td>Room</td>
								<td>Grand Total</td>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td><input type="text" id="new-transaction" name="new-transaction" placeholder="Transaction Number here..." required></td>
								<td><input type="text" id="new-wallet-number" name="new-wallet-number" placeholder="Wallet Number here..." required></td>
								<td><input type="text" id="new-room" name="new-room" placeholder="Room here..." required></td>
								<td><input type="text" id="new-grand-total" name="new-grand-total" placeholder="Grand Total here..." required></td>
							</tr>
							<tr>
								<td>
									<input type="hidden" name="operation" value="insert">
									<input type="submit" value="Insert Transaction">
								<td/>
							</tr>
						</tbody>
					</table>
					<br/>
				</form>
			</div>
	</body>
</html>
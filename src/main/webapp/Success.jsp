<%@ page language="java" %>

<html>
	<head>
		<title>Success</title>
	</head>
	<body>
		<%@ include file="./sidebarCart.jsp" %>	
		<h1><b>Your cart items has been successfully saved to the database </b></h1>
		<hr/>
		<a href="./product.do?action=display">Product Catalog</a>
		<hr/>
			<form action="./cartServlet" method="GET">
				<input type="submit" value="View Cart">
			</form>
		<script type="text/javascript" src="./static/js/sidebar.js"></script>
	</body>
</html>
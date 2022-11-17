<%@ page language="java" %>

<html>
	<head>
		<title>Success</title>
	</head>
	<body>
		<h1><b>Your cart items has been succesfully saved to the database </b></h1>
		<hr/>
		<a href="./productServlet">Product Catalog</a>
		<hr/>
			<form action="./cartServlet" method="GET">
				<input type="submit" value="View Cart">
			</form>
	</body>
</html>
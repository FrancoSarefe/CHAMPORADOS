<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java"%>

<html>
<head>
<meta charset='utf-8'>
<meta name='viewport' content='width=device-width, initial-scale=1'>

<title>CHAMP CAFETERIA</title>

<link rel="stylesheet" href="./static/css/bootstrap.min.css">
<link rel="stylesheet" href="./static/css/mdb.min.css">
<link rel="stylesheet" href="./static/css/site.css">
<script type="text/javascript" src="./static/js/app.js"></script>
<script type="text/javascript" src="./static/js/bootstrap.bundle.min.js"></script>


<link
	href='https://cdn.jsdelivr.net/npm/boxicons@latest/css/boxicons.min.css'
	rel='stylesheet'>

<script src="https://kit.fontawesome.com/06060ec4ae.js"
	crossorigin="anonymous"></script>
<link rel="stylesheet" href="./static/css/custom.css">

</head>


<body id="body-pd">
	<header class="header" id="header">
		<div class="header_toggle">
			<i class='bx bx-menu' id="header-toggle"></i>
		</div>


		<div class="header_img">
			<img src="./static/images/champ.logo.png" alt="">
		</div>
	</header>
	<div class="l-navbar" id="nav-bar">
		<nav class="nav">
			<div>
				<a href="#" class="nav_logo" style="padding: .5rem 0 .5rem 1.0rem">
					<img src="./static/images/champ.logo.png" alt=""
					style="background-color: white; width: 35px; border-radius: 10%;"><span
					class="nav_logo-name" style="font-size: 14px;">CHAMP
						CAFETERIA</span>
				</a>

				<div class="nav_list" style="">


					<a href="#" class="nav_link"> <i class='bx bx-user nav_icon'></i>
						<span class="nav_name">Users</span>

					</a> <a href="#" class="nav_link active"> <i
						class='bx bx-grid-alt nav_icon'></i> <span class="nav_name">Products</span>

					</a> <a href="#" class="nav_link"> <i
						class='bx bx-message-square-check nav_icon'></i> <span
						class="nav_name">Orders</span>

					</a> <a href="#" class="nav_link"> <i
						class='bx bx-bar-chart-alt-2 nav_icon'></i> <span class="nav_name">Transactions</span>
					</a>
				</div>
			</div>
			<a href="#" class="nav_link"> <i class='bx bx-log-out nav_icon'></i>
				<span class="nav_name">SignOut</span>
			</a>
		</nav>
	</div>
	<!--Container Main start-->
	<div>
		<c:if test="${empty product}">
			<b>Empty ProductCatalog!</b>
		</c:if>
		
		<c:if test="${not empty product}">
			<table>
				<thead>
					<tr>
						<td>PRODUCT NUMBER</td>
						<td>Name</td>
						<td>DESCRIPTION</td>
						<td>PRICE</td>
						<td>QUANTITY</td>
						<td>CATEGORY</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${product}" var="item">
							<tr>
								<td><c:out value="${item.productNumber}" /></td>
								<td><c:out value="${item.productName}" /></td>
								<td><c:out value="${item.description}" /></td>
								<td><c:out value="${item.price}" /></td>
								<td><c:out value="${item.quantity}" /></td>
								<td><c:out value="${item.category}" /></td>
								<td>
							</tr>
					
					</c:forEach>
				</tbody>
			</table>
		</c:if>

	</div>
	<!--Container Main end-->


	<script type="text/javascript" src="./static/js/sidebar.js"></script>

</body>
</html>
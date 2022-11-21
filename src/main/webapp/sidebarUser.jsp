<head>
<meta charset='utf-8'>
<meta name='viewport' content='width=device-width, initial-scale=1'>

<title>CHAMP CAFETERIA</title>

<link rel="stylesheet" href="./static/css/bootstrap.min.css">
<link rel="stylesheet" href="./static/css/mdb.min.css">
<link rel="stylesheet" href="./static/css/site.css">


<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>


<link
	href='https://cdn.jsdelivr.net/npm/boxicons@latest/css/boxicons.min.css'
	rel='stylesheet'>

<script src="https://kit.fontawesome.com/06060ec4ae.js"></script>
<link rel="stylesheet" href="./static/css/custom.css">
<link rel="stylesheet" href="./static/css/product.css">

</head>

<header class="header" id="header">

	<div class="header_toggle">
		<i class='bx bx-menu' id="header-toggle"></i>
	</div>

		<form class="input-group ml-5 mr-5" action="./product.do?action=display" method="post" id="headerForm">

			<input type="search" class="form-control rounded mt-3 mb-2"
				placeholder="Search" 
				style="height: 45px;" name="searchProduct" id="searchProduct" onkeyup='saveValue(this)' /> 
				
			<select
				class="form-select mt-3 mr-3" name="filterByCategory"
				style="width: 150px; height: 45px; font-size: 14px; font-style: italic;" onchange="this.form.submit()">
				<option value="" selected>Category</option>
				<option value="Breakfast">Breakfast</option>
				<option value="Lunch">Lunch</option>
				<option value="Snacks">Snacks</option>
			</select>

			<button type="submit" class="mt-3 mb-2" id="actionButton"
				style="margin-left: -8px; background-color: #707070; width: 100px; height: 43px; background: #00d2ff; background: #00d2ff; background: -webkit-linear-gradient(to top, #3a7bd5, #00d2ff); background: linear-gradient(to top, #3a7bd5, #00d2ff);">
				<i class="fas fa-search"></i>
			</button>

		</form>


	<button type="button" id="addProductModal" style="margin-top:-1px;margin-left:-40px;width: 60px">
		<i class="fa-solid fa-plus" style="font-size: 18px;"></i>
	</button>

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

				<a href="./loginSuccess.jsp" class="nav_link active"> <i class='bx bx-user nav_icon'></i>
					<span class="nav_name">Users</span>

				</a> <a href="./product.do?action=display" class="nav_link">
					<i class='bx bx-grid-alt nav_icon'></i> <span class="nav_name">Products</span>

				</a> <a href="./Cart.jsp" class="nav_link"> <i
					class='bx bx-message-square-check nav_icon'></i> <span
					class="nav_name">Cart</span>

				</a> <a href="./transactions" class="nav_link"> <i
					class='bx bx-bar-chart-alt-2 nav_icon'></i> <span class="nav_name">Transactions</span>
				</a>
			</div>
		</div>
		<a href="#" class="nav_link"> <i class='bx bx-log-out nav_icon'></i>
			<span class="nav_name">Sign Out</span>
		</a>
	</nav>
</div>
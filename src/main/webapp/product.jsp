<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java"%>

<html>

<head>
<meta charset='utf-8'>
<meta name='viewport' content='width=device-width, initial-scale=1'>

<c:if test="${action == 'add'}">
	 <input type="hidden" id="actionAlert" name="actionAlert" value="add">
</c:if>

<c:if test="${action == 'delete'}">
	<input type="hidden" id="actionAlert" name="actionAlert" value="delete">
</c:if>

<c:if test="${action == 'update'}">
	<input type="hidden" id="actionAlert" name="actionAlert" value="update">
		
</c:if>


<!--  
<c:if test="${category == 'BREAKFAST'}">
	<input type="hidden" id="categoryAlert" name="categoryAlert" value="Breakfast">
</c:if>

<c:if test="${category == 'LUNCH'}">
	<input type="hidden" id="categoryAlert" name="categoryAlert" value="Lunch">
</c:if>

<c:if test="${category == 'SNACKS'}">
	<input type="hidden" id="categoryAlert" name="categoryAlert" value="Snacks">
</c:if>
-->



<title>CHAMP CAFETERIA</title>

<link rel="stylesheet" href="./static/css/bootstrap.min.css">
<link rel="stylesheet" href="./static/css/mdb.min.css">
<link rel="stylesheet" href="./static/css/site.css">

<!-- 
<script type="text/javascript" src="./static/js/app.js"></script>
<script type="text/javascript" src="./static/js/bootstrap.bundle.min.js"></script>
-->


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




<body id="body-pd">
	<!-- <header class="header" id="header">

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

	</header> -->

	<!-- <div class="l-navbar" id="nav-bar">
		<nav class="nav">
			<div>
				<a href="#" class="nav_logo" style="padding: .5rem 0 .5rem 1.0rem">
					<img src="./static/images/champ.logo.png" alt=""
					style="background-color: white; width: 35px; border-radius: 10%;"><span
					class="nav_logo-name" style="font-size: 14px;">CHAMP
						CAFETERIA</span>
				</a>

				<div class="nav_list" style="">

					<a href="" class="nav_link"> <i class='bx bx-user nav_icon'></i>
						<span class="nav_name">Users</span>

					</a> <a href="./product.do?action=display" class="nav_link active">
						<i class='bx bx-grid-alt nav_icon'></i> <span class="nav_name">Products</span>

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
	</div> -->
	
	<%@ include file="./sidebar.jsp" %>

	<br>

	<div>

		<div class="container-xl mr-3">
			<div class="row">
				<div class="col-md-12">
					<div class="table-wrap">
						<!--bottom scroll-->

						<c:if test="${empty product}">
							<b>Empty ProductCatalog!</b>
						</c:if>

						<c:if test="${not empty product}">
							<table class="table" id="product_Table">
								<thead class="thead-primary">
									<tr>
										<th>Product Number
											<button class="sortButton" onclick="sortTable(0)">
												<i class="fa-solid fa-sort" style="color: white;"></i>
											</button>
										</th>
										<th>Image</th>
										<th>Product
											<button class="sortButton" onclick="sortTable(2)">
												<i class="fa-solid fa-sort" style="color: white;"></i>
											</button>
										</th>
										<th>Category
											<button class="sortButton" onclick="sortTable(3)">
												<i class="fa-solid fa-sort" style="color: white;"></i>
											</button>
										</th>
										<th>Quantity
											<button class="sortButton" onclick="sortTable(4)">
												<i class="fa-solid fa-sort" style="color: white;"></i>
											</button>
										</th>
										<th>Price
											<button class="sortButton" onclick="sortTable(5)">
												<i class="fa-solid fa-sort" style="color: white;"></i>
											</button>
										</th>
										<th style="width:">Actions</th>

									</tr>
								</thead>
								<tbody>

									<c:forEach items="${product}" var="item">


										<tr class="alert" role="alert">


											<td><c:out value="${item.productNumber}" /></td>
											<!-- 0 -->


											<td>
												<div class="img"
													style="background-image: url(./static/images/champ.logo.png);"></div>
											</td>



											<td style="display: none;"><c:out
													value="${item.productName}" /></td>
											<!-- 2 -->

											<td style="display: none;"><c:out
													value="${item.description}" /></td>
											<!-- 3 -->


											<td>
												<div class="email">
													<span><c:out value="${item.productName}" /></span> <span><c:out
															value="${item.description}" /></span>
												</div>
											</td>


											<td><c:out value="${item.category}" /></td>
											<!-- 5 -->

											<td><c:out value="${item.quantity}" /></td>
											<!-- 6 -->

											<td><c:out value="${item.price}"/></td>
											<!-- 7 -->

											<td>



												<button class="btnUpdate" id="actionButton"
													style="background-color: #707070;">
													<i class="fa-solid fa-pen-to-square"></i>
												</button>


												<button class="btnDelete" id="actionButton"
													style="background-color: #C91F45;">
													<i class="far fa-trash-alt"></i>
												</button>
												
												<form
													action="${pageContext.request.contextPath}/cartServlet?action=add"
													method="POST" style="width=20px; float: right; margin-left: -15px; margin-top: -10px">
													<input type="hidden" name="prodNum" value="${item.productNumber} ">						
													<input type="hidden" name="price" value="${item.price} ">
													<input type="hidden" name="quantity" value="${item.quantity} ">
													<button id="actionButton" type="submit"
														style="background-color: green;">
														<i class="fa-solid fa-plus"></i>
													</button>
												</form>


											</td>
										</tr>

									</c:forEach>

								</tbody>
							</table>
						</c:if>

					</div>
				</div>
			</div>
		</div>

	</div>
	<!--Container Main end-->



	<!-- The Modal -->
	<div class="modal" id="modalAddProduct">

		<!-- Modal content -->
		<div class="modal-content" style="width: 450px;">


			<div class="flex">
				<img src="./static/images/addbackground.png" class="nav_logo-name"
					style="width: 100%; height: 170px; border-bottom: 1px solid black; margin-top: 10px;">
			</div>


			<form action="./product.do?action=add" method="post">

				<fieldset>

					<input type="text" name="product_Name" placeholder="Product Name" pattern="[a-zA-Z]{5,}"
						title="Product Name must contain at least 5 letters or more!" required>
					
					<textarea name="product_Description"
						placeholder="Product Description" maxlength="100" minlength="20"
						title="Product Description must contain at least 20 letters or more!" required></textarea>
					<input type="number" name="product_Price" placeholder="Price" min="0" oninput="validity.valid||(value='');" 
						required> 
						
						
					<input type="number" name="product_Quantity"
						placeholder="Quantity" min="1" oninput="validity.valid||(value='');"  required> <select
						name="product_Category" style="height: 35px;" required>
						<option value="" selected>Category</option>
						<option value="Breakfast">Breakfast</option>
						<option value="Lunch">Lunch</option>
						<option value="Snacks">Snacks</option>
					</select> 
					
					<input type="file" name="product_Image">

				</fieldset>

				<div class="form-row" style="margin-top: -5px;">
					<div class="col">
						<button class="closeAddModalProduct" id="button"
							style="background-color: #707070" data-dismiss="modal">Cancel</button>
					</div>
					<div class="col">
						<button type="submit" id="button"
							style="background-color: #C91F45">Submit</button>
					</div>
				</div>

			</form>
		</div>

	</div>


	<!-- The Modal -->
	<div class="modal" id="modalDeleteProduct">

		<!-- Modal content -->
		<div class="modal-content" style="width: 450px; margin-top: 100px;">

			<div class="modal-header" style="background-color: #C91F45">
				<h5 class="modal-title" style="color: white;">Delete Product</h5>
			</div>

			<form action="./product.do?action=delete" method="POST">

				<div class="modal-body">

					<hr>
					<p>Are you sure you want to delete?</p>
					<input type="text" name="productNumberDelete"
						id="productNumberDelete"
						style="font-size: 30px; color: black; text-align: center;"
						readonly>
					<hr>


				</div>
				<div class="modal-footer">

					<input class="closeDeleteModalProduct" id="button"
						style="background-color: #707070" value="close">

					<button type="submit" id="button" style="background-color: #C91F45">Submit</button>
				</div>

			</form>

		</div>

	</div>


	<!-- The Modal -->
	<div class="modal" id="modalUpdateProduct">

		<!-- Modal content -->
		<div class="modal-content" style="width: 450px;">

			<div class="flex">
				<img src="./static/images/updatebackground.png"
					class="nav_logo-name"
					style="width: 100%; height: 170px; border-bottom: 1px solid black; margin-top: 10px;">
			</div>


			<form action="./product.do?action=update" method="post">

				<fieldset>
				
					<div class="mb-2" id="productNumberUpdateIndicator" style="width: 100%; height: 20px; color: white; background-color:#C91F45; font-size: 14px; text-align: center;"></div>

					<input type="hidden" name="productNumberUpdate"
						id="productNumberUpdate"> 
						
						
						<input type="text"
						name="product_Name" id="product_NameUpdate"
						placeholder="Product Name" pattern="[a-zA-Z]{5,}"
						title="Product Name must contain at least 5 letters or more!"  required>
						
						
					<textarea name="product_Description" id="product_DescriptionUpdate"
						placeholder="Product Description" maxlength="100" minlength="20"
						title="Product Description must contain at least 20 letters or more!" required></textarea>

					<input type="number" name="product_Price" id="product_PriceUpdate"
						placeholder="Price" min="0" oninput="validity.valid||(value='');" required> 
						
						
						
						<input type="number"
						name="product_Quantity" id="product_QuantityUpdate"
						placeholder="Quantity" min="1" oninput="validity.valid||(value='');" required> 
						
						
					<select
						name="product_Category" id="product_CategoryUpdate"
						style="height: 35px;" required>
						<option value="" selected>Category</option>
						<option value="Breakfast">Breakfast</option>
						<option value="Lunch">Lunch</option>
						<option value="Snacks">Snacks</option>
					</select> <input type="file" name="product_Image">

				</fieldset>

				<div class="form-row" style="margin-top: -5px;">
					<div class="col">
					
					<input class="closeUpdateModalProduct" id="button"
						style="background-color: #707070" value="Cancel">
						
					</div>
					<div class="col">
						<button type="submit" id="button"
							style="background-color: #C91F45">Update</button>
					</div>
				</div>

			</form>


		</div>

	</div>
	
	
	
	<script>
	
	
        document.getElementById("searchProduct").value = getSavedValue("searchProduct");    // set the value to this input
        /* Here you can add more inputs to set value. if it's saved */

        //Save the value function - save it to localStorage as (ID, VALUE)
        function saveValue(e){
            var id = e.id;  // get the sender's id to save it . 
            var val = e.value; // get the value. 
            localStorage.setItem(id, val);// Every time user writing something, the localStorage's value will override . 
        }

        //get the saved value function - return the value of "v" from localStorage. 
        function getSavedValue  (v){
            if (!localStorage.getItem(v)) {
                return "";// You can change this to your defualt value. 
            }
            return localStorage.getItem(v);
        }
        
        
        
	</script>
	
	<script>
	window.onload = function () { 
		
		
			if (document.getElementById('actionAlert').value == "add") {

				location.href = "./product.do?action=display";
				alert("Product is Successfully Added!");
				
			}

			if (document.getElementById('actionAlert').value == "delete") {

				
				location.href = "./product.do?action=display";

				alert("Product is Successfully Deleted!");
				
			}

			if (document.getElementById('actionAlert').value == "update") {

			
				location.href = "./product.do?action=display";
				alert("Product is Successfully Updated!");

			
			}
			
		}
	</script>


	<script>
		var modal = document.getElementById('modalAddProduct');
		var btn = document.getElementById("addProductModal");
		var span = modal.getElementsByClassName("closeAddModalProduct")[0];

		btn.onclick = function() {

			modal.style.display = "block";
		}

		span.onclick = function() {
			modal.style.display = "none";
		}

		var modal1 = document.getElementById('modalDeleteProduct');
		var span1 = modal1.getElementsByClassName("closeDeleteModalProduct")[0];

		span1.onclick = function() {
			modal1.style.display = "none";
		}

		var modal2 = document.getElementById('modalUpdateProduct');
		var span2 = modal2.getElementsByClassName("closeUpdateModalProduct")[0];

		span2.onclick = function() {
			modal2.style.display = "none";
		}
		
		
	</script>



	<script>
		$(document)
				.ready(
						function() {

							$("#product_Table")
									.on(
											'click',
											'.btnDelete',
											function() {

												var currentRow = $(this)
														.closest("tr");
												var productNumber = currentRow
														.find("td:eq(0)")
														.text();

												document
														.getElementById("productNumberDelete").value = productNumber;
												document
														.getElementById("modalDeleteProduct").style.display = "block";

											});

							$("#product_Table")
									.on(
											'click',
											'.btnUpdate',
											function() {

												var currentRow = $(this)
														.closest("tr");

												var productNumber = currentRow
														.find("td:eq(0)")
														.text();
												var productName = currentRow
														.find("td:eq(2)")
														.text();
												var description = currentRow
														.find("td:eq(3)")
														.text();

												var category = currentRow.find(
														"td:eq(5)").text();
												var quantity = currentRow.find(
														"td:eq(6)").text();
												var price = currentRow.find(
														"td:eq(7)").text();

												document
														.getElementById("productNumberUpdate").value = productNumber;
												
												document
														.getElementById("productNumberUpdateIndicator").innerHTML  = "PRODUCT NUMBER: " + productNumber;
												
												document
														.getElementById("product_NameUpdate").value = productName;
												document
														.getElementById("product_DescriptionUpdate").value = description;

												//document.getElementById("product_CategoryUpdate").value = category;

												let element = document
														.getElementById("product_CategoryUpdate");
												element.value = category;

												document
														.getElementById("product_QuantityUpdate").value = quantity;
												document
														.getElementById("product_PriceUpdate").value = price;

												document
														.getElementById("modalUpdateProduct").style.display = "block";

												//document.getElementById("productNumberDelete").value = productNumber;
												//document.getElementById("modalDeleteProduct").style.display = "block";

											});
						});
	</script>

	<script>
		function sortTable(n) {
			var table, rows, switching, i, x, y, shouldSwitch, dir, switchcount = 0;
			table = document.getElementById("product_Table");
			switching = true;

			dir = "asc";

			while (switching) {

				switching = false;
				rows = table.getElementsByTagName("TR");

				for (i = 1; i < rows.length - 1; i++) {
					shouldSwitch = false;

					x = rows[i].getElementsByTagName("TD")[n];
					y = rows[i + 1].getElementsByTagName("TD")[n];

					if (dir == "asc") {
						if (x.innerHTML.toLowerCase() > y.innerHTML
								.toLowerCase()) {

							shouldSwitch = true;
							break;
						}
					} else if (dir == "desc") {
						if (x.innerHTML.toLowerCase() < y.innerHTML
								.toLowerCase()) {

							shouldSwitch = true;
							break;
						}
					}
				}
				if (shouldSwitch) {

					rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
					switching = true;
					switchcount++;

				} else {

					if (switchcount == 0 && dir == "asc") {
						dir = "desc";
						switching = true;
					}
				}
			}
		}
	</script>



	<script type="text/javascript" src="./static/js/sidebar.js"></script>

</body>
</html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" %>
<jsp:useBean id="loginFormBean" class="bean.LoginFormBean" scope="session"/>
<html>
	<!-- <head>
		<title>CHAMP Cafeteria::Login</title>
		<link rel="stylesheet" href="./static/css/bootstrap.min.css">
		<link rel="stylesheet" href="./static/css/mdb.min.css">
		<link rel="stylesheet" href="./static/css/site.css">
		<link rel="stylesheet" href="./static/css/login.css">
		
		<script type="text/javascript" src="./static/js/bootstrap.bundle.min.js"></script>
		<script type="text/javascript" src="./static/js/mdb.min.js"></script>

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
		
		<style type="text/css">
			body {
			    margin: 50px;
			}
		</style>
	</head> -->
	<body id="body-pd">
		<%@ include file="./sidebarUser.jsp" %>
		<h2>Welcome, <c:out value="${loginFormBean.firstName }"/></h2><br/>
		<h4>Your current balance is: <b>Php <c:out value="${loginFormBean.amount }"/></b></h4><br/>
		<form action="${pageContext.request.contextPath }/updateUser.jsp">
			<button type="submit" class="btn btn-primary">Update Personal Info</button><br/>
		</form>
		<form action="${pageContext.request.contextPath }/deleteUser.do">
			<button type="submit" class="btn btn-primary">Delete Account</button><br/>
		</form>
		<script type="text/javascript" src="./static/js/sidebar.js"></script>
	</body>
</html>
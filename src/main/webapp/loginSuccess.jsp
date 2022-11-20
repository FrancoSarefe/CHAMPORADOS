<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" %>
<jsp:useBean id="loginFormBean" class="bean.LoginFormBean" scope="session"/>
<html>
	<head>
		<title>CHAMP Cafeteria::Login</title>
		<link rel="stylesheet" href="./static/css/bootstrap.min.css">
		<link rel="stylesheet" href="./static/css/mdb.min.css">
		<link rel="stylesheet" href="./static/css/site.css">
		<link rel="stylesheet" href="./static/css/login.css">
		
		<script type="text/javascript" src="./static/js/bootstrap.bundle.min.js"></script>
		<script type="text/javascript" src="./static/js/mdb.min.js"></script>
		
		<style type="text/css">
			body {
			    margin: 50px;
			}
		</style>
	</head>
	<body>
	    <h2>Success</h2>
	    <hr />
		Welcome,
		<c:out value="${loginFormBean.companyEmail }"/><br/>
		<form action="${pageContext.request.contextPath }/register.do">
			<button type="submit" class="btn btn-primary">Order History</button><br/>
		</form>
		<form action="${pageContext.request.contextPath }/updateUser.jsp">
			<button type="submit" class="btn btn-primary">Update Personal Info</button><br/>
		</form>
		<form action="${pageContext.request.contextPath }/deleteUser.do">
			<button type="submit" class="btn btn-primary">Delete Account</button><br/>
		</form>
	</body>
</html>
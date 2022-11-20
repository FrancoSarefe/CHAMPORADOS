<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java"%>
<jsp:useBean id="registationFormBean" class="bean.RegistrationFormBean"
	scope="request" />
<html>
<head>
<title>CHAMP Cafeteria::Registration</title>
<link rel="stylesheet" href="./static/css/login.css">
<style type="text/css">
.formMargin {
	margin-top: 120px;
}
</style>
</head>
<body>
	<%@ include file="./indexHeader.jsp"%>
	<div class="formMargin">
		<h2>Registration Success</h2>
		<br /> Welcome,
		<c:out value="${registrationFormBean.firstName }" />
		! You may now <a href="login.jsp">Login</a>.
	</div>
</body>
</html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" %>
<jsp:useBean id="registrationFormBean" class="bean.RegistrationFormBean" scope="request"/>
<html>
<head>
<title>Webshoppe::Registration</title>
<style type="text/css">
body {
    margin: 50px;
}
.error {
	color: #FF0000;
	font-weight: bold;
}
</style>
</head>
<body>
    <h2>User Registration</h2>
    <hr />
	<form action="${pageContext.request.contextPath }/register.do">
		Username <input type="text" name="username" value="${registrationFormBean.username }">
		<span class="error"><%= registrationFormBean.getError("username") %></span>
		<br/>
		First Name <input type="text" name="firstName" value="${registrationFormBean.firstName }">
		<span class="error"><%= registrationFormBean.getError("firstName") %></span>
		<br/>
		Last Name <input type="text" name="lastName" value="${registrationFormBean.lastName }">
		<span class="error"><%= registrationFormBean.getError("lastName") %></span>
		<br/>
		Email <input type="text" name="email" value="${registrationFormBean.email }">
		<span class="error"><%= registrationFormBean.getError("email") %></span>
		<br/>
		Password <input type="text" name="password">
		<span class="error"><%= registrationFormBean.getError("password") %></span>
		<br/>
		Confirm Password <input type="text" name="confirmPassword">
		<br/>
		<input type="submit" value="Register">
	</form>
</body>
</html>
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
		Company Email <input type="text" name="companyEmail" value="${registrationFormBean.companyEmail }">
		<span class="error"><%= registrationFormBean.getError("email") %></span>
		<br/>
		First Name <input type="text" name="firstName" value="${registrationFormBean.firstName }">
		<span class="error"><%= registrationFormBean.getError("firstName") %></span>
		<br/>
		Middle Name <input type="text" name="middleName" value="${registrationFormBean.middleName }">
		<br/>
		Last Name <input type="text" name="lastName" value="${registrationFormBean.lastName }">
		<span class="error"><%= registrationFormBean.getError("lastName") %></span>
		<br/>
		Birth Date <input type="date" name="birthDate" value="${registrationFormBean.birthDate }">
		<br/>
		Contact Number <input type="number" name="contactNumber" value="${registrationFormBean.contactNumber }">
		<br/>
		Password <input type="password" name="password">
		<span class="error"><%= registrationFormBean.getError("password") %></span>
		<br/>
		Confirm Password <input type="password" name="confirmPassword">
		<br/>
		<input type="submit" value="Register">
	</form>
</body>
</html>
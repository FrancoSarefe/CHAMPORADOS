<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" %>
<jsp:useBean id="registrationFormBean" class="bean.RegistrationFormBean" scope="request"/>
<html>
<head>
<title>CHAMP Cafeteria::Login</title>
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
    <h2>User Login</h2>
    <hr />
	<form action="${pageContext.request.contextPath }/login.do">
		Company Email <input type="text" name="companyEmail" value="${registrationFormBean.companyEmail }" required>
		<span class="error"><%= registrationFormBean.getError("email") %></span>
		<br/>
		First Name <input type="text" name="firstName" value="${registrationFormBean.firstName }" required>
		<span class="error"><%= registrationFormBean.getError("firstName") %></span>
		<br/>
		Middle Name <input type="text" name="middleName" value="${registrationFormBean.middleName }">
		<br/>
		Last Name <input type="text" name="lastName" value="${registrationFormBean.lastName }" required>
		<span class="error"><%= registrationFormBean.getError("lastName") %></span>
		<br/>
		Birth Date <input type="date" name="birthDate" value="${registrationFormBean.birthDate }" required>
		<br/>
		Contact Number <input type="number" name="contactNumber" value="${registrationFormBean.contactNumber }" required>
		<br/>
		Password <input type="password" name="password" required>
		<span class="error"><%= registrationFormBean.getError("password") %></span>
		<br/>
		Confirm Password <input type="password" name="confirmPassword" required>
		<br/>
		<input type="submit" value="Register">
	</form>
</body>
</html>
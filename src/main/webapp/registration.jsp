<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java"%>
<jsp:useBean id="registrationFormBean" class="bean.RegistrationFormBean"
	scope="request" />
<html>
<head>
<title>CHAMP Cafeteria::Registration</title>
<link rel="stylesheet" href="./static/css/login.css">
<style type="text/css">
.formMargin {
	margin-top: 100px;
}
</style>
</head>
<body>
	<%--     <h2>User Registration</h2>
	    <hr />
		<form action="${pageContext.request.contextPath }/register.do">
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
		</form> --%>
	<%@ include file="./indexHeader.jsp"%>
	<main id="main" role="main" class=" aui-page-panel">
		<div class="formMargin">
			<div id="login-container">
				<div class="login-section ">

					<form name="loginform" method="POST"
						action="${pageContext.request.contextPath }/register.do"
						class="aui login-form-container">

						<h2>Register</h2>

						<div id="action-messages"></div>
						<fieldset class="compact-form-fields">

							<div class="field-group">
								<label id="os_username-label" for="os_username"> Company
									Email </label> <input type="text" name="companyEmail" id="os_username"
									class="text" placeholder="Username" data-focus="0"
									value="${registrationFormBean.companyEmail }" required>
								<span class="error"><%=registrationFormBean.getError("email")%></span>
							</div>

							<div class="field-group">
								<label id="os_username-label" for="os_username"> First
									Name </label> <input type="text" name="firstName" id="os_username"
									class="text" placeholder="First Name" data-focus="0"
									value="${registrationFormBean.firstName }" required> <span
									class="error"><%=registrationFormBean.getError("firstName")%></span>
							</div>

							<div class="field-group">
								<label id="os_username-label" for="os_username"> Middle
									Name </label> <input type="text" name="middleName" id="os_username"
									class="text" placeholder="Middle Name" data-focus="0"
									value="${registrationFormBean.middleName }"> <span
									class="error"><%=registrationFormBean.getError("middleName")%></span>
							</div>

							<div class="field-group">
								<label id="os_username-label" for="os_username"> Last
									Name </label> <input type="text" name="lastName" id="os_username"
									class="text" placeholder="Last Name" data-focus="0"
									value="${registrationFormBean.lastName }" required> <span
									class="error"><%=registrationFormBean.getError("lastName")%></span>
							</div>

							<div class="field-group">
								<label id="os_username-label" for="os_username"> Birth
									Date </label> <input type="date" name="birthDate" id="os_username"
									class="text" data-focus="0"
									value="${registrationFormBean.birthDate }" required> <span
									class="error"><%=registrationFormBean.getError("birthDate")%></span>
							</div>

							<div class="field-group">
								<label id="os_username-label" for="os_username"> Contact
									Number </label> <input type="text" name="contactNumber"
									id="os_username" class="text" placeholder="Contact Number"
									data-focus="0" value="${registrationFormBean.contactNumber }"
									required> <span class="error"><%=registrationFormBean.getError("contactNumber")%></span>
							</div>

							<div class="field-group">
								<label id="os_password-label" for="os_password">
									Password </label> <input type="password" name="password"
									id="os_password" class="password " placeholder="Password"
									value="${registrationFormBean.password }" required> <span
									class="error"><%=registrationFormBean.getError("password")%></span>
							</div>

							<div class="field-group">
								<label id="os_password-label" for="os_password"> Confirm
									Password </label> <input type="password" name="confirmPassword"
									id="os_password" class="password "
									placeholder="Confirm Password"
									value="${registrationFormBean.confirmPassword }" required>
							</div>

							<div class="field-group form-buttons compact-form-buttons ">
								<input id="loginButton"
									class="aui-button aui-style aui-button-primary" name="login"
									type="submit" value="Register" resolved="">
							</div>
							<input type="hidden" name="os_destination"
								value="/pages/viewpage.action?spaceKey=PDLC&amp;title=CHAMPStart+-+Batch+4+-+October+2022">
						</fieldset>

					</form>
				</div>
			</div>
		</div>
	</main>
</body>
</html>
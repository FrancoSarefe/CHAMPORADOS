<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" %>
<jsp:useBean id="loginFormBean" class="bean.LoginFormBean" scope="session"/>
<jsp:useBean id="registrationFormBean" class="bean.RegistrationFormBean" scope="request"/>
<html>
	<head>
		<title>CHAMP Cafeteria::Update User</title>
		<link rel="stylesheet" href="./static/css/login.css">
	</head>
	<body>
	<%--     <h2>User Registration</h2>
	    <hr />
		<form action="${pageContext.request.contextPath }/register.do">
			Company Email <input type="text" name="companyEmail" value="${loginFormBean.companyEmail }" required>
			<span class="error"><%= loginFormBean.getError("email") %></span>
			<br/>
			First Name <input type="text" name="firstName" value="${loginFormBean.firstName }" required>
			<span class="error"><%= loginFormBean.getError("firstName") %></span>
			<br/>
			Middle Name <input type="text" name="middleName" value="${loginFormBean.middleName }">
			<br/>
			Last Name <input type="text" name="lastName" value="${loginFormBean.lastName }" required>
			<span class="error"><%= loginFormBean.getError("lastName") %></span>
			<br/>
			Birth Date <input type="date" name="birthDate" value="${loginFormBean.birthDate }" required>
			<br/>
			Contact Number <input type="number" name="contactNumber" value="${loginFormBean.contactNumber }" required>
			<br/>
			Password <input type="password" name="password" required>
			<span class="error"><%= loginFormBean.getError("password") %></span>
			<br/>
			Confirm Password <input type="password" name="confirmPassword" required>
			<br/>
			<input type="submit" value="Register">
		</form> --%>
		<main id="main" role="main" class=" aui-page-panel">
	
			<div id="login-container">
				<div class="login-section ">
	
					<form name="loginform" method="POST"
						action="${pageContext.request.contextPath }/updateUser.do"
						class="aui login-form-container">
	
						<h2>Update Info</h2>
	
						<div id="action-messages"></div>
						<fieldset class="compact-form-fields">
	
							<div class="field-group">
								<label id="os_username-label" for="os_username"> Company Email 
								</label> <input type="text" name="companyEmail" id="os_username"
									class="text" data-focus="0"
									value="${loginFormBean.companyEmail }" required> <span
									class="error"><%=registrationFormBean.getError("email")%></span>
							</div>
							
							<div class="field-group">
								<label id="os_username-label" for="os_username"> First Name 
								</label> <input type="text" name="firstName" id="os_username"
									class="text" data-focus="0"
									value="${loginFormBean.firstName }" required> <span
									class="error"><%=registrationFormBean.getError("firstName")%></span>
							</div>
							
							<div class="field-group">
								<label id="os_username-label" for="os_username"> Middle Name 
								</label> <input type="text" name="middleName" id="os_username"
									class="text" data-focus="0"
									value="${loginFormBean.middleName }"> <span
									class="error"><%=registrationFormBean.getError("middleName")%></span>
							</div>
							
							<div class="field-group">
								<label id="os_username-label" for="os_username"> Last Name 
								</label> <input type="text" name="lastName" id="os_username"
									class="text" data-focus="0"
									value="${loginFormBean.lastName }" required> <span
									class="error"><%=registrationFormBean.getError("lastName")%></span>
							</div>
							
							<div class="field-group">
								<label id="os_username-label" for="os_username"> Birth Date 
								</label> <input type="date" name="birthDate" id="os_username"
									class="text" data-focus="0"
									value="${loginFormBean.birthDate }" required> <span
									class="error"><%=registrationFormBean.getError("birthDate")%></span>
							</div>
							
							<div class="field-group">
								<label id="os_username-label" for="os_username"> Contact Number 
								</label> <input type="text" name="contactNumber" id="os_username"
									class="text" data-focus="0"
									value="${loginFormBean.contactNumber }" required> <span
									class="error"><%=registrationFormBean.getError("contactNumber")%></span>
							</div>
	
							<div class="field-group">
								<label id="os_password-label" for="os_password"> Password
								</label> <input type="password" name="password" id="os_password"
									class="password "
									value="${loginFormBean.password }" required> <span
									class="error"><%=registrationFormBean.getError("password")%></span>
							</div>
							
							<div class="field-group">
								<label id="os_password-label" for="os_password"> Confirm Password
								</label> <input type="password" name="confirmPassword" id="os_password"
									class="password " required>
							</div>
	
							<div class="field-group form-buttons compact-form-buttons ">
								<input id="loginButton"
									class="aui-button aui-style aui-button-primary" name="login"
									type="submit" value="Update" resolved="">
							</div>
							<input type="hidden" name="os_destination"
								value="/pages/viewpage.action?spaceKey=PDLC&amp;title=CHAMPStart+-+Batch+4+-+October+2022">
						</fieldset>
	
					</form>
				</div>
			</div>
	
		</main>
	</body>
</html>
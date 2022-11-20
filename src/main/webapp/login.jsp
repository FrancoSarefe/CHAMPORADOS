<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java"%>
<jsp:useBean id="loginFormBean" class="bean.LoginFormBean"
	scope="session" />
<html>
<head>
<title>CHAMP Cafeteria::Login</title>
<link rel="stylesheet" href="./static/css/login.css">
<style type="text/css">
.formMargin {
	margin-top: 100px;
}
</style>
</head>
<body>
	<%--     <h2>User Login</h2>
	    <hr />
		<form action="${pageContext.request.contextPath }/login.do">
			Company Email <input type="text" name="companyEmail" value="${loginFormBean.companyEmail }" required>
			<span class="error"><%= loginFormBean.getError("email") %></span>
			<br/>
			Password <input type="password" name="password" value="${loginFormBean.password }" required>
			<span class="error"><%= loginFormBean.getError("password") %></span>
			<br/>
			<input type="submit" value="Login">
		</form> --%>
	<%@ include file="./indexHeader.jsp"%>
	<div class="formMargin">
		<main id="main" role="main" class=" aui-page-panel">

			<div id="login-container">
				<div class="login-section ">

					<form name="loginform" method="POST"
						action="${pageContext.request.contextPath }/login.do"
						class="aui login-form-container">

						<h2>Log In</h2>

						<div id="action-messages"></div>
						<fieldset class="compact-form-fields">

							<div class="field-group">
								<label id="os_username-label" for="os_username"> Company
									Email </label> <input type="text" name="companyEmail" id="os_username"
									class="text" placeholder="Username" data-focus="0"
									value="${loginFormBean.companyEmail }" required> <span
									class="error"><%=loginFormBean.getError("email")%></span>
							</div>

							<div class="field-group">
								<label id="os_password-label" for="os_password">
									Password </label> <input type="password" name="password"
									id="os_password" class="password " placeholder="Password"
									value="${loginFormBean.password }" required> <span
									class="error"><%=loginFormBean.getError("password")%></span>
							</div>

							<div class="group">
								No Account? <a href="registration.jsp">Register</a>
							</div>

							<div class="field-group form-buttons compact-form-buttons ">
								<input id="loginButton"
									class="aui-button aui-style aui-button-primary" name="login"
									type="submit" value="Log In" resolved="">
							</div>
							<input type="hidden" name="os_destination"
								value="/pages/viewpage.action?spaceKey=PDLC&amp;title=CHAMPStart+-+Batch+4+-+October+2022">
						</fieldset>

					</form>
				</div>
			</div>

		</main>
	</div>
</body>
</html>
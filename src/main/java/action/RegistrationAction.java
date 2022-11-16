package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.RegistrationFormBean;

public class RegistrationAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RegistrationFormBean registrationFormBean = toRegistrationFormBean(request);
		request.setAttribute("registrationFormBean", registrationFormBean);
		if(registrationFormBean.validate()) {
			return "/registrationSuccess.jsp";
		}
		return "/registration.jsp";
	}
	
	private RegistrationFormBean toRegistrationFormBean(HttpServletRequest request) {
		RegistrationFormBean registrationFormBean = new RegistrationFormBean();
		registrationFormBean.setUsername(request.getParameter("username"));
		registrationFormBean.setFirstName(request.getParameter("firstName"));
		registrationFormBean.setLastName(request.getParameter("lastName"));
		registrationFormBean.setEmail(request.getParameter("email"));
		registrationFormBean.setPassword(request.getParameter("password"));
		registrationFormBean.setConfirmPassword(request.getParameter("confirmPassword"));
		return registrationFormBean;
	}

}

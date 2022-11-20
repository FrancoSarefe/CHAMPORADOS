package action;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.UnknownServiceException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.LoginFormBean;
import bean.RegistrationFormBean;
import jdbc.JdbcConnectionManager;
import repository.BalanceRepository;
import repository.PersonRepository;
import repository.UserRepository;
import service.BalanceService;
import service.PersonService;
import service.UserService;
import utils.IdGenerator;

public class UpdateUserAction implements Action {
	
	private UserRepository userRepository;
    private PersonRepository personRepository;
	
	private UserService userService;
	private PersonService personService;

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			final Connection connection = JdbcConnectionManager.instance().initiate().getConnection();
			userRepository = new UserRepository(connection);
			personRepository = new PersonRepository(connection);
			
			userService = new UserService(userRepository);
			personService = new PersonService(personRepository);
			
			HttpSession session = request.getSession(true);
			LoginFormBean loginFormBean = (LoginFormBean) session.getAttribute("loginFormBean");
			
			RegistrationFormBean registrationFormBean = toRegistrationFormBean(request, userService);
			request.setAttribute("registrationFormBean", registrationFormBean);
			
			if(registrationFormBean.validate()) {
				String userNumber = loginFormBean.getUserNumber();
				String personNumber = loginFormBean.getPersonNumber();
				
				userService.updateUser(userNumber, registrationFormBean.getCompanyEmail(), registrationFormBean.getPassword());
				personService.updatePerson(personNumber, registrationFormBean.getFirstName(), registrationFormBean.getMiddleName(), registrationFormBean.getLastName(), registrationFormBean.getBirthDate(), registrationFormBean.getContactNumber());
				setLoginFormBean(loginFormBean, registrationFormBean.getCompanyEmail(), registrationFormBean.getFirstName(), registrationFormBean.getMiddleName(), registrationFormBean.getLastName(), registrationFormBean.getBirthDate(), registrationFormBean.getContactNumber(), registrationFormBean.getPassword());
				return "/registrationSuccess.jsp";
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return "/updateUser.jsp";
		
	}
	
	private RegistrationFormBean toRegistrationFormBean(HttpServletRequest request, UserService userService) {
		RegistrationFormBean registrationFormBean = new RegistrationFormBean(userService);
		registrationFormBean.setCompanyEmail(request.getParameter("companyEmail"));
		registrationFormBean.setFirstName(request.getParameter("firstName"));
		registrationFormBean.setMiddleName(request.getParameter("middleName"));
		registrationFormBean.setLastName(request.getParameter("lastName"));
		registrationFormBean.setBirthDate(request.getParameter("birthDate"));
		registrationFormBean.setContactNumber(request.getParameter("contactNumber"));
		registrationFormBean.setPassword(request.getParameter("password"));
		registrationFormBean.setConfirmPassword(request.getParameter("confirmPassword"));
		return registrationFormBean;
	}
	
	private void setLoginFormBean(LoginFormBean loginFormBean, String companyEmail, String firstName, String middleName, String lastName, String birthDate, String contactNumber, String password) {
		loginFormBean.setCompanyEmail(companyEmail);
		loginFormBean.setFirstName(firstName);
		loginFormBean.setMiddleName(middleName);
		loginFormBean.setLastName(lastName);
		loginFormBean.setBirthDate(birthDate);
		loginFormBean.setContactNumber(contactNumber);
		loginFormBean.setPassword(password);
	}

}

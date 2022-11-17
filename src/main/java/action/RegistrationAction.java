package action;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.RegistrationFormBean;
import jdbc.JdbcConnectionManager;
import repository.BalanceRepository;
import repository.PersonRepository;
import repository.UserRepository;
import service.BalanceService;
import service.PersonService;
import service.UserService;
import utils.IdGenerator;

public class RegistrationAction implements Action {
	
	private UserRepository userRepository;
    private PersonRepository personRepository;
    private BalanceRepository balanceRepository;
	
	private UserService userService;
	private PersonService personService;
	private BalanceService balanceService;
	
	private IdGenerator idGenerator;

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			final Connection connection = JdbcConnectionManager.instance().initiate().getConnection();
			userRepository = new UserRepository(connection);
			personRepository = new PersonRepository(connection);
			balanceRepository = new BalanceRepository(connection);
			
			userService = new UserService(userRepository);
			personService = new PersonService(personRepository);
			balanceService = new BalanceService(balanceRepository);
			
			idGenerator = new IdGenerator(connection);
			
			RegistrationFormBean registrationFormBean = toRegistrationFormBean(request);
			request.setAttribute("registrationFormBean", registrationFormBean);
			
			if(registrationFormBean.validate(userService)) {
				String userId = idGenerator.generateId("User");
				String personId = idGenerator.generateId("Person");
				String balanceId = idGenerator.generateId("Balance");
				
				userService.insertUser(userId, registrationFormBean.getCompanyEmail(), registrationFormBean.getPassword(), new Date(), false, personId);
				personService.insertPerson(personId, registrationFormBean.getFirstName(), registrationFormBean.getMiddleName(), registrationFormBean.getLastName(), registrationFormBean.getBirthDate(), registrationFormBean.getContactNumber());
				balanceService.insertBalance(balanceId, new BigDecimal(3000), userId);
				return "/registrationSuccess.jsp";
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return "/registration.jsp";
		
	}
	
	private RegistrationFormBean toRegistrationFormBean(HttpServletRequest request) {
		RegistrationFormBean registrationFormBean = new RegistrationFormBean();
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

}

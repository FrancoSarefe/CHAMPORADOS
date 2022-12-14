package action;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.LoginFormBean;
import jdbc.JdbcConnectionManager;
import repository.BalanceRepository;
import repository.PersonRepository;
import repository.UserRepository;
import service.BalanceService;
import service.PersonService;
import service.UserService;

public class LoginAction implements Action {
	
	private UserRepository userRepository;
	private PersonRepository personRepository;
	private BalanceRepository balanceRepository;
	
	private UserService userService;
	private PersonService personService;
	private BalanceService balanceService;

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection connection;
		try {
			connection = JdbcConnectionManager.instance().initiate().getConnection();
			userRepository = new UserRepository(connection);
			personRepository = new PersonRepository(connection);
			balanceRepository = new BalanceRepository(connection);
			
			userService = new UserService(userRepository);
			personService = new PersonService(personRepository);
			balanceService = new BalanceService(balanceRepository);
			
			HttpSession session = request.getSession(true);
			
			LoginFormBean loginFormBean = toLoginFormBean(request, userService, personService, balanceService);
			session.setAttribute("loginFormBean", loginFormBean);
			
			if(loginFormBean.validate()) {
				return "/loginSuccess.jsp";
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return "/login.jsp";
	}
	
	private LoginFormBean toLoginFormBean(HttpServletRequest request, UserService userService, PersonService personService, BalanceService balanceService) {
		LoginFormBean loginFormBean = new LoginFormBean(request.getParameter("companyEmail"), request.getParameter("password"), userService, personService, balanceService);
		return loginFormBean;
	}

}

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

public class DeleteUserAction implements Action {
	
	private UserRepository userRepository;
    private PersonRepository personRepository;
    private BalanceRepository balanceRepository;
	
	private UserService userService;
	private PersonService personService;
	private BalanceService balanceService;

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
			
			HttpSession session = request.getSession(true);
			LoginFormBean loginFormBean = (LoginFormBean) session.getAttribute("loginFormBean");
			
			String userNumber = loginFormBean.getUserNumber();
			String personNumber = loginFormBean.getPersonNumber();
			
			userService.deleteUser(userNumber);
			personService.deletePerson(personNumber);
			balanceService.deleteBalance(userNumber);
			
			session.invalidate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return "/login.jsp";
		
	}

}

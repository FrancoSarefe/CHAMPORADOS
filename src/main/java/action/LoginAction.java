package action;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.LoginFormBean;
import jdbc.JdbcConnectionManager;
import repository.BalanceRepository;
import repository.UserRepository;
import service.BalanceService;
import service.UserService;

public class LoginAction implements Action {
	
	private UserRepository userRepository;
	private BalanceRepository balanceRepository;
	
	private UserService userService;
	private BalanceService balanceService;

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection connection;
		try {
			connection = JdbcConnectionManager.instance().initiate().getConnection();
			userRepository = new UserRepository(connection);
			balanceRepository = new BalanceRepository(connection);
			
			userService = new UserService(userRepository);
			balanceService = new BalanceService(balanceRepository);
			
			LoginFormBean loginFormBean = toLoginFormBean(request);
			request.setAttribute("loginFormBean", loginFormBean);
			
			if(loginFormBean.validate(userService)) {
				loginFormBean.setWalletNumber(balanceService.findByUserNumber(loginFormBean.getUserNumber()));
				return "/loginSuccess.jsp";
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return "/login.jsp";
	}
	
	private LoginFormBean toLoginFormBean(HttpServletRequest request) {
		LoginFormBean loginFormBean = new LoginFormBean();
		loginFormBean.setCompanyEmail(request.getParameter("companyEmail"));
		loginFormBean.setPassword(request.getParameter("password"));
		return loginFormBean;
	}

}

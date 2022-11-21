package servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.LoginFormBean;
import cart.CartItem;
import cart.CartRepository;
import cart.CartRepositoryService;
import entity.BalanceEntity;
import entity.TransactionEntity;
import jdbc.JdbcConnectionManager;
import jdbc.JdbcConnectionManager2;
import repository.BalanceRepository;
import repository.TransactionRepository;
import service.BalanceService;
import service.TransactionService;
import utils.IdGenerator;

@WebServlet("/checkout")
public class CheckoutServlet extends HttpServlet{

	private static final long serialVersionUID = 6734138456353186919L;
	
	private CartRepositoryService cartRepositoryService;
	private TransactionService transactionService;
	private BalanceService balanceService;
	
	private BalanceRepository balanceRepository;
	private IdGenerator idGenerator;

	@Override
	public void init() throws ServletException {
		Connection connection;
		try {
			connection = JdbcConnectionManager.instance().initiate().getConnection();	
			final CartRepository cartRepository = new CartRepository(connection);
			final TransactionRepository transactionRepository = new TransactionRepository(connection);
			balanceRepository = new BalanceRepository(connection);
			idGenerator = new IdGenerator(connection);
			
			cartRepositoryService = new CartRepositoryService(cartRepository);
			transactionService = new TransactionService(transactionRepository);
			balanceService = new BalanceService(balanceRepository);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		HttpSession session = req.getSession(true);
		LoginFormBean loginFormBean = (LoginFormBean) session.getAttribute("loginFormBean");

        String walletNumber = loginFormBean.getWalletNumber();

		final List<CartItem> cartItems = getCartItemsByWalletNumber(walletNumber);
		BigDecimal grandTotal = getGrandTotalOfCartItems(cartItems);
		BalanceEntity balance = balanceService.getBalanceByWalletNumber(walletNumber);
		boolean isBalanceEnough = (balance.getAmount().subtract(grandTotal).doubleValue() >= 0);
		setAttributes(req, walletNumber, cartItems, grandTotal, balance, isBalanceEnough);
		final RequestDispatcher dispatcher = req.getRequestDispatcher("/checkout.jsp");
		dispatcher.forward(req, resp);
	}

	private void setAttributes(HttpServletRequest req, final String walletNumber, final List<CartItem> cartItems,
			BigDecimal grandTotal, BalanceEntity balance, boolean isBalanceEnough) {
		req.setAttribute("cartItems", cartItems);
		req.setAttribute("grandTotal", grandTotal);
		req.setAttribute("balanceAmount", balance.getAmount().doubleValue());
		req.setAttribute("isBalanceEnough", isBalanceEnough);
		req.setAttribute("walletNumber", walletNumber);
	}

	private BigDecimal getGrandTotalOfCartItems(final List<CartItem> cartItems) {
		BigDecimal grandTotal = new BigDecimal(0);
		for (CartItem cartItem : cartItems) {
			grandTotal = grandTotal.add(cartItem.getTotalPrice());
		}
		return grandTotal;
	}

	private List<CartItem> getCartItemsByWalletNumber(final String walletNumber) {
		final List<CartItem> cartItems;
		if (walletNumber != null)
			cartItems = cartRepositoryService.getCartByWallet(walletNumber);
		else
			cartItems = cartRepositoryService.getCart();
		return cartItems;
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		
		if(req.getParameter("do").equals("get")) {
			doGet(req, resp);
			return;
		}
		
		final String walletNumber = req.getParameter("walletNumber");
		final String room = req.getParameter("room");
		
		final List<CartItem> cartItems = getCartItemsByWalletNumber(walletNumber);
		BigDecimal grandTotal = getGrandTotalOfCartItems(cartItems);
		
		//update cart items database for is_checked_out
		cartRepositoryService.updateCartItemIsCheckedOut();
		
		//update amount in balance
		BalanceEntity balance = balanceService.getBalanceByWalletNumber(walletNumber);
		BigDecimal newAmount = balance.getAmount().subtract(grandTotal);
		balanceService.setBalanceAmount(newAmount, walletNumber);
		
		//insert new transaction in database
		final String transactionNumber = idGenerator.generateId("Transaction");
		transactionService.addTransaction(transactionNumber, 
										  walletNumber, 
										  room, 
										  grandTotal.floatValue());
		
		List<TransactionEntity> transactions = transactionService.getTransactionByTransactionNumber(transactionNumber);
		req.setAttribute("cartItems", cartItems);
		req.setAttribute("transactions", transactions);
		req.setAttribute("remainingBalance", newAmount.doubleValue());
		
		HttpSession session = req.getSession(true);
		LoginFormBean loginFormBean = (LoginFormBean) session.getAttribute("loginFormBean");
		
		loginFormBean.setAmount(newAmount);
		
		final RequestDispatcher dispatcher = req.getRequestDispatcher("/checkout-success.jsp");
		dispatcher.forward(req, resp);
	}
}

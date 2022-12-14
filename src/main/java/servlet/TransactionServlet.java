package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.LoginFormBean;
import entity.TransactionEntity;
import jdbc.JdbcConnectionManager;
import repository.TransactionRepository;
import service.TransactionService;
import service.TransactionSorterService;

@WebServlet("/transactions")
public class TransactionServlet extends HttpServlet {

	private static final long serialVersionUID = -3622402514313367468L;
	
	private TransactionService transactionService;
	private TransactionSorterService transactionSorterService;
	
	@Override
	public void init() throws ServletException {
		Connection connection;
		try {
			connection = JdbcConnectionManager.instance().initiate().getConnection();
			final TransactionRepository transactionRepository = new TransactionRepository(connection);
			transactionService = new TransactionService(transactionRepository);
			transactionSorterService = new TransactionSorterService();
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
		
		final List<TransactionEntity> transactions = transactionService.getTransactionsByWalletNumber(walletNumber);
		Collections.sort(transactions, transactionSorterService.sortByFilter());
        forwardTransactionsToDispatcher(req, resp, transactions);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		final String operation = req.getParameter("operation");
		final List<TransactionEntity> transactions;
		switch (operation) {
		case "insert":
			transactions = executeInsertOperation(req);
			break;
		case "update":
			transactions = executeUpdateOperation(req);
			break;
		case "search":
			transactions = executeSearchOperation(req);
			break;
		case "filter":
			transactions = executeFilterOperation(req);
			break;
		default:
			transactions = transactionService.getAllTransactions();
		}
		forwardTransactionsToDispatcher(req, resp, transactions);
	}

	private List<TransactionEntity> executeSearchOperation(HttpServletRequest req) {
		final List<TransactionEntity> transactions;
		final String searchFilter = req.getParameter("search-filter");
		final String searchParameter = req.getParameter("search-parameter");
		System.out.println(searchParameter);
		switch (searchFilter) {
			case "Wallet Number":
				transactions = transactionService.getTransactionsByWalletNumber(searchParameter);
				break;
			case "Transaction Number":
				transactions = transactionService.getTransactionByTransactionNumber(searchParameter);
				break;
			default:
				transactions = transactionService.getAllTransactions();
		}
		return transactions;
	}

	private List<TransactionEntity> executeInsertOperation(HttpServletRequest req) {
		final List<TransactionEntity> transactions;
		final String newTransaction = req.getParameter("new-transaction");
		final String newWalletNumber = req.getParameter("new-wallet-number");
		final String newRoom = req.getParameter("new-room");
		final float newGrandTotal = Float.parseFloat(req.getParameter("new-grand-total"));
		transactionService.addTransaction(newTransaction, newWalletNumber, newRoom, newGrandTotal);
		transactions = transactionService.getAllTransactions();
		return transactions;
	}

	private List<TransactionEntity> executeUpdateOperation(HttpServletRequest req) {
		final List<TransactionEntity> transactions;
		final String newStatus = req.getParameter("status-update");
		final String selectedId = req.getParameter("selected-transaction");
		transactionService.setTransactionStatus(selectedId, newStatus);
		transactions = transactionService.getTransactionByTransactionNumber(selectedId);
		return transactions;
	}
	
	private List<TransactionEntity> executeFilterOperation(HttpServletRequest req) {
		final List<TransactionEntity> transactions = transactionService.getAllTransactions();;
		final String sortFilter = req.getParameter("sort-filter");
		Collections.sort(transactions, transactionSorterService.sortByFilter(sortFilter));
		return transactions;
	}

	private void forwardTransactionsToDispatcher(HttpServletRequest req, HttpServletResponse resp,
			final List<TransactionEntity> transactions) throws ServletException, IOException {
		req.setAttribute("transactions", transactions);
		final RequestDispatcher dispatcher = req.getRequestDispatcher("/transactions.jsp");
		dispatcher.forward(req, resp);
	}
}

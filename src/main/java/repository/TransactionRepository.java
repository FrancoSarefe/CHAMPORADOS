package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.ToyEntity;
import entity.TransactionEntity;
import exception.DataAccessException;
import jdbc.JdbcConnectionManager;

public class TransactionRepository {
	
	private final static String SELECT = "Select *";
			//"SELECT t.id, t.transaction_number, t.cart_number, t.room, t.grand_total, t.date_created, t.status";
	private final static String SELECT_ALL = SELECT + " FROM transaction t";
	private final static String SELECT_BY_USER_ID = SELECT_ALL + " FROM transaction t, cart_item c"
													+ " WHERE t.cart_number = c.cart_number AND c.user_number = ?";
	private final static String INSERT_TRANSACTION_DETAILS = "INSERT INTO transaction (transaction_number, cart_number, room, grand_total, date_created, status) VALUES (?,?,?,?,?,'Pending')";
	private final static String UPDATE_TRANSACTION_STATUS = "UPDATE transaction SET status = ? WHERE transaction_number = ?";
	
	private final static int COLUMN_ID = 1;
	private final static int COLUMN_TRANSACTION_NUMBER = 2;
	private final static int COLUMN_CART_NUMBER = 3;
	private final static int COLUMN_ROOM = 4;
	private final static int COLUMN_GRAND_TOTAL = 5;
	private final static int COLUMN_DATE_CREATED = 6;
	private final static int COLUMN_STATUS = 7;
	
    private JdbcConnectionManager jdbcConnectionManager;

    public TransactionRepository(JdbcConnectionManager jdbcConnectionManager) {
        this.jdbcConnectionManager = jdbcConnectionManager;
    }
    
    public List<TransactionEntity> findAll() {
    	try {
            final Connection connection = jdbcConnectionManager.getConnection();
            final PreparedStatement statement = connection.prepareStatement(SELECT_ALL);
            final ResultSet resultSet = statement.executeQuery();
            final List<TransactionEntity> transactions = new ArrayList<>();
            while (resultSet.next()) {
                transactions.add(toTransaction(resultSet));
            }
            System.out.println(transactions.size());
            return transactions;
        } catch (Exception e) {
            throw DataAccessException.instance("Failed to retrieve transactions: " + e.getMessage());
        }
    }
    
    public List<TransactionEntity> findByUserId(int id) {
    	try {
            final Connection connection = jdbcConnectionManager.getConnection();
            final PreparedStatement statement = connection.prepareStatement(SELECT_BY_USER_ID);
            statement.setInt(1, id);
            final ResultSet resultSet = statement.executeQuery();
            final List<TransactionEntity> transactions = new ArrayList<>();
            while (resultSet.next()) {
            	transactions.add(toTransaction(resultSet));
            }

            return transactions;
        } catch (Exception e) {
            throw DataAccessException.instance("Failed to retrieve transactions: " + e.getMessage());
        }
    }
    
    public void updateTransactionStatus(String transactionNumber, String status) {
    	try {
			PreparedStatement statement = jdbcConnectionManager.getConnection().prepareStatement(UPDATE_TRANSACTION_STATUS);
			statement.setString(1, status);
			statement.setString(2, transactionNumber);
			
			int numberRowsAffected = statement.executeUpdate();
    		if (numberRowsAffected > 1)
    			throw new RuntimeException("Number of rows is greater than 1.");
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    public void insertTransaction(String transactionNumber, String cartNumber, String room, 
    							  float grandTotal, String dateCreated) {
		try {
			final Connection connection = jdbcConnectionManager.getConnection();
            final PreparedStatement statement = connection.prepareStatement(INSERT_TRANSACTION_DETAILS);
	    	statement.setString(1, transactionNumber);
	    	statement.setString(2, cartNumber);
	    	statement.setString(3, room);
	    	statement.setFloat(4, grandTotal);
	    	statement.setString(5, dateCreated);
	    	
	    	final ResultSet resultSet = statement.executeQuery();
	    	
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }

	private TransactionEntity toTransaction(final ResultSet resultSet)
			throws SQLException {
		TransactionEntity transaction = new TransactionEntity
			(
				resultSet.getInt(COLUMN_ID),
				resultSet.getString(COLUMN_TRANSACTION_NUMBER),
				resultSet.getString(COLUMN_CART_NUMBER),
				resultSet.getString(COLUMN_ROOM),
				resultSet.getFloat(COLUMN_GRAND_TOTAL),
				resultSet.getString(COLUMN_DATE_CREATED),
				resultSet.getString(COLUMN_STATUS)
			);
		return transaction;
	}
}

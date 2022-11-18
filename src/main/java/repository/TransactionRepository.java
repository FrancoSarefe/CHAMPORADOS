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
	
	private final static String SELECT = "SELECT t.id, t.transaction_number, t.cart_number, t.room, t.grand_total, t.date_created, t.status";
	private final static String SELECT_ALL = SELECT + " FROM transactions t";
	private final static String SELECT_BY_USER_ID = SELECT_ALL + " FROM transaction t, cart_item c, champ_user u"
													+ " WHERE t.cart_number = c.cart_number AND c.user_number = u.user_number";
	
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

            final PreparedStatement findAllQuery = connection.prepareStatement(SELECT_ALL);

            final ResultSet resultSet = findAllQuery.executeQuery();
            final List<TransactionEntity> transactions = new ArrayList<>();
            while (resultSet.next()) {
                toTransaction(resultSet, transactions);
            }

            return transactions;
        } catch (Exception e) {
            throw DataAccessException.instance("Failed to retrieve transactions: " + e.getMessage());
        }
    }
    
    public List<TransactionEntity> findByUserId() {
    	try {
            final Connection connection = jdbcConnectionManager.getConnection();
            final PreparedStatement findAllQuery = connection.prepareStatement(SELECT_BY_USER_ID);
            final ResultSet resultSet = findAllQuery.executeQuery();
            final List<TransactionEntity> transactions = new ArrayList<>();
            while (resultSet.next()) {
                toTransaction(resultSet, transactions);
            }

            return transactions;
        } catch (Exception e) {
            throw DataAccessException.instance("Failed to retrieve transactions: " + e.getMessage());
        }
    }

	private void toTransaction(final ResultSet resultSet, final List<TransactionEntity> transactions)
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
		transactions.add(transaction);
	}
}

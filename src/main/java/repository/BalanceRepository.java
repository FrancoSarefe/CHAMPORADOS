package repository;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entity.BalanceEntity;
import exception.DataAccessException;
import jdbc.JdbcConnectionManager;

public class BalanceRepository {
	
    private final static String BALANCE_FIND_ALL = "SELECT wallet_number, amount, user_number FROM Balance";
    private static final String INSERT_BALANCE = "INSERT INTO Balance(wallet_number, amount, user_number) VALUES (?,?,?)";
    private final static String BALANCE_FIND_BY_WALLET_NUMBER = BALANCE_FIND_ALL + " WHERE wallet_number = ?";
    private final static String UPDATE_BALANCE_AMOUNT = "UPDATE balance SET amount = ? WHERE wallet_number = ?";
    
    private Connection connection;
    
    public BalanceRepository(Connection connection) {
    	this.connection = connection;
    }

    public List<BalanceEntity> findAll() {
        try {
            final PreparedStatement findAllQuery = connection.prepareStatement(BALANCE_FIND_ALL);

            final ResultSet resultSet = findAllQuery.executeQuery();
            final List<BalanceEntity> balances = new ArrayList<>();
            while (resultSet.next()) {
                BalanceEntity balance = new BalanceEntity(resultSet.getString(1), resultSet.getBigDecimal(2), resultSet.getString(3));
                balances.add(balance);
            }

            return balances;
        } catch (Exception e) {
            throw DataAccessException.instance("failed_to_retrieve_balances: " + e.getMessage());
        }
    }

    public boolean insertBalance(String walletNumber, BigDecimal amount, String userNumber) {
		try {
            final PreparedStatement insertQuery = connection.prepareStatement(INSERT_BALANCE);
            
			insertQuery.setString(1, walletNumber);
			insertQuery.setBigDecimal(2, amount);
			insertQuery.setString(3, userNumber);

			insertQuery.executeUpdate();
			
			return true;
            
		} catch (Exception e) {
			throw DataAccessException.instance("failed_to_insert_balance: " + e.getMessage());
			
		}

	}
    
    public BalanceEntity findByWalletNumber(String walletNumber) {
    	try {
    		final PreparedStatement statement = connection.prepareStatement(BALANCE_FIND_BY_WALLET_NUMBER);
    		statement.setString(1, walletNumber);
            final ResultSet resultSet = statement.executeQuery();
            BalanceEntity balance = null;
            while (resultSet.next()) {
            	 balance = new BalanceEntity(resultSet.getString(1), resultSet.getBigDecimal(2), resultSet.getString(3));
            }
            return balance;
    	} catch (Exception e) {
    		throw DataAccessException.instance("failed_to_retrieve_balance: " + e.getMessage());
    	}
    }
    
    public void updateBalanceAmount(BigDecimal amount, String walletNumber) {
    	try {
			final PreparedStatement statement = connection.prepareStatement(UPDATE_BALANCE_AMOUNT);
			statement.setBigDecimal(1, amount);
			statement.setString(2, walletNumber);
			statement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
    }
}

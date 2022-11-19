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
    private final static String BALANCE_FIND_USER_NUMBER = BALANCE_FIND_ALL + " WHERE user_number = ?";
    private static final String INSERT_BALANCE = "INSERT INTO Balance(wallet_number, amount, user_number) VALUES (?,?,?)";
    
    private Connection connection;
    private PreparedStatement query;
    private ResultSet resultSet;
    
    public BalanceRepository(Connection connection) {
    	this.connection = connection;
    }

    public List<BalanceEntity> findAll() {
        try {
            query = connection.prepareStatement(BALANCE_FIND_ALL);

            final ResultSet resultSet = query.executeQuery();
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
    
    public String findByUserNumber(String userNumber) {
    	try {
            query = connection.prepareStatement(BALANCE_FIND_USER_NUMBER);
            query.setString(1, userNumber);

            resultSet = query.executeQuery();
            
            String walletNumber = null;
            if (resultSet.next()) {
            	walletNumber = resultSet.getString(1);
            }

            return walletNumber;
        } catch (Exception e) {
            throw DataAccessException.instance("failed_to_retrieve_users: " + e.getMessage());
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
}

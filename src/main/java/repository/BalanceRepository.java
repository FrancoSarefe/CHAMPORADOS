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
	
    private final static String BALANCE_FIND_ALL = "SELECT * FROM Balance";
    private static final String INSERT_BALANCE = "INSERT INTO Balance(wallet_number, amount) VALUES (?,?)";

    public List<BalanceEntity> findAll() {
        try {
        	final Connection connection = JdbcConnectionManager.instance().initiate().getConnection();

            final PreparedStatement findAllQuery = connection.prepareStatement(BALANCE_FIND_ALL);

            final ResultSet resultSet = findAllQuery.executeQuery();
            final List<BalanceEntity> balances = new ArrayList<>();
            while (resultSet.next()) {
                BalanceEntity balance = new BalanceEntity(resultSet.getString(1), resultSet.getBigDecimal(2));
                balances.add(balance);
            }

            return balances;
        } catch (Exception e) {
            throw DataAccessException.instance("failed_to_retrieve_balances: " + e.getMessage());
        }
    }

    public boolean insertBalance(String walletNumber, BigDecimal amount) {
		try {
			final Connection connection = JdbcConnectionManager.instance().initiate().getConnection();

            final PreparedStatement insertQuery = connection.prepareStatement(INSERT_BALANCE);
            
			insertQuery.setString(1, walletNumber);
			insertQuery.setBigDecimal(2, amount);

			insertQuery.executeUpdate();
			
			return true;
            
		} catch (Exception e) {
			throw DataAccessException.instance("failed_to_insert_balance: " + e.getMessage());
			
		}

	}
}

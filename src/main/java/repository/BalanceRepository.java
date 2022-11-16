package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.BalanceEntity;
import exception.DataAccessException;
import jdbc.JdbcConnectionManager;

public class BalanceRepository {
	
    private final static String TOY_FIND_ALL = "SELECT * FROM Balance";
 

    private JdbcConnectionManager jdbcConnectionManager;

    public BalanceRepository(JdbcConnectionManager jdbcConnectionManager) {
        this.jdbcConnectionManager = jdbcConnectionManager;
    }

    public List<BalanceEntity> findAll() {
        try {
            final Connection connection = jdbcConnectionManager.getConnection();

            final PreparedStatement findAllQuery = connection.prepareStatement(TOY_FIND_ALL);

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

   
}

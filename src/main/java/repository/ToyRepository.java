package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.ToyEntity;
import exception.DataAccessException;
import jdbc.JdbcConnectionManager;

public class ToyRepository {
	
    private final static String TOY_FIND_ALL = "SELECT tid, tname, tdesc, tprice FROM ToysDetails";
 

    private JdbcConnectionManager jdbcConnectionManager;

    public ToyRepository(JdbcConnectionManager jdbcConnectionManager) {
        this.jdbcConnectionManager = jdbcConnectionManager;
    }

    public List<ToyEntity> findAll() {
        try {
            final Connection connection = jdbcConnectionManager.getConnection();

            final PreparedStatement findAllQuery = connection.prepareStatement(TOY_FIND_ALL);

            final ResultSet resultSet = findAllQuery.executeQuery();
            final List<ToyEntity> toys = new ArrayList<>();
            while (resultSet.next()) {
            	System.out.println("test");
                ToyEntity toy = new ToyEntity(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getBigDecimal(4));
                toys.add(toy);
            }

            return toys;
        } catch (Exception e) {
            throw DataAccessException.instance("failed_to_retrieve_toys: " + e.getMessage());
        }
    }

   
}

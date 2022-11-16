package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.Product;
import exception.DataAccessException;
import jdbc.JdbcConnectionManager;

public class ProductRepository {
	
    private final static String FETCH_ALL_PRODUCTS = "SELECT * FROM CHAMP_PRODUCT";
      
    public List<Product> findAll() {
    	
        try {
        	
            final Connection connection = JdbcConnectionManager.instance().initiate().getConnection();//database connection

            final PreparedStatement findAllQuery = connection.prepareStatement(FETCH_ALL_PRODUCTS);

            final List<Product> products = new ArrayList<>();
            final ResultSet resultSet = findAllQuery.executeQuery();
           
            while (resultSet.next()) {
            	
               Product product = new Product(resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getBigDecimal(5), resultSet.getBigDecimal(6), resultSet.getString(7));
               products.add(product);
            }
            
            return products;
            
        } catch (Exception e) {
            throw DataAccessException.instance("FAILED TO FETCH PRODUCTS! " + e.getMessage());
        }
    }

   
}

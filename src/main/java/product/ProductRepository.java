package product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import exception.DataAccessException;
import jdbc.JdbcConnectionManager;

public class ProductRepository {
    private Connection conn;

    private final static String GET_ALL = "SELECT product_number, product_name, description, price, quantity, category FROM CHAMP_product ORDER BY product_number ";

    public ProductRepository(Connection connection) {
        this.conn = connection;
    }

    public List<Product> listAll() {
        try {
            PreparedStatement stmt = conn.prepareStatement(GET_ALL);
            ResultSet res = stmt.executeQuery();
            List<Product> prodList = new ArrayList<>();
            while (res.next()) {
                Product prod = new Product(res.getString(1),
                                           res.getString(2),
                                           res.getString(3),
                                           res.getBigDecimal(4),
                                           res.getInt(5),
                                           res.getString(6));
                prodList.add(prod);
            }
            return prodList;

        } catch (Exception e) {
            throw new DataAccessException("Retrievel Error: " + e.getMessage());
        }
    }

}

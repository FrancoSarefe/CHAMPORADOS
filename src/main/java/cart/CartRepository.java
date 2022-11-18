package cart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import exception.DataAccessException;
import jdbc.JdbcConnectionManager;

public class CartRepository {
    private JdbcConnectionManager connector;
    private Connection conn;

    private final static String GET_ALL = "SELECT cart_number, quantity, total_price, product_number, user_number FROM cart_item ORDER BY product_number";
    private final static String DELETE = "DELETE FROM cart_item where product_number = ?";

    public CartRepository() {
        connector = new JdbcConnectionManager();

    }

    public List<CartItem> listall() {
        try {
            conn = connector.getConnection();
            PreparedStatement stmt = conn.prepareStatement(GET_ALL);
            ResultSet res = stmt.executeQuery();
            List<CartItem> cartList = new ArrayList<>();
            while (res.next()) {
                CartItem cart = new CartItem(res.getString(1), res.getInt(2), res.getBigDecimal(3), res.getString(4), res.getString(5));
                cartList.add(cart);
            }
            return cartList;

        } catch (Exception e) {
            throw new DataAccessException("Retrievel Error: " + e.getMessage());
        }

    }

    public void remove(int prodNum) {
        //int prodNumber = Integer.valueOf(prodNum);
        
        try {
            conn = connector.getConnection();
            PreparedStatement stmt = conn.prepareStatement(DELETE);
            stmt.setInt(1, prodNum);
            stmt.executeUpdate();
        } catch (Exception e) {
            throw new DataAccessException("Retrievel Error: " + e.getMessage());
        }
    }
}

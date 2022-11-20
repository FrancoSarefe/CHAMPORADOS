package cart;

import java.math.BigDecimal;
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

    private final static String GET_ALL = "SELECT cart_item_number, quantity, total_price, product_number, wallet_number FROM cart_item ORDER BY product_number";
    private final static String GET_BY_WALLETNUMBER = "SELECT cart_item_number, quantity, total_price, product_number, wallet_number FROM cart_item WHERE wallet_number = ? AND is_checked_out = 'false' ORDER BY product_number";
    private final static String UPDATE_IS_CHECKED_OUT = "UPDATE cart_item SET is_checked_out = 'true' WHERE is_checked_out = 'false'";
    private final static String DELETE = "DELETE FROM cart_item where product_number = ?";
    private BigDecimal grandTotalPrice;
    public CartRepository() {
        connector = new JdbcConnectionManager();
        grandTotalPrice = new BigDecimal(0);
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
                addTotalPrice(res.getBigDecimal(3));
            }
            return cartList;

        } catch (Exception e) {
            throw new DataAccessException("Retrievel Error: " + e.getMessage());
        }

    }
    
    public List<CartItem> listByWalletNumber(String walletNumber){
        try {
            conn = connector.getConnection();
            PreparedStatement stmt = conn.prepareStatement(GET_BY_WALLETNUMBER);
            stmt.setString(1, walletNumber);
            ResultSet res = stmt.executeQuery();
            List<CartItem> cartList = new ArrayList<>();
            while (res.next()) {
                CartItem cart = new CartItem(res.getString(1), res.getInt(2), res.getBigDecimal(3), res.getString(4), res.getString(5));
                cartList.add(cart);
                addTotalPrice(res.getBigDecimal(3));
            }
            return cartList;

        } catch (Exception e) {
            throw new DataAccessException("Retrieval Error: " + e.getMessage());
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
    
    public void updateCartItemIsCheckedOut() {
    	try {
    		conn = connector.getConnection();
    		PreparedStatement statement = conn.prepareStatement(UPDATE_IS_CHECKED_OUT);
    		statement.executeUpdate();
    	} catch (Exception e) {
    		e.printStackTrace();
		}
    }
    
    private void addTotalPrice(BigDecimal price) {
        this.grandTotalPrice = this.grandTotalPrice.add(price);
    }
    
    public BigDecimal getGrandTotalPrice() {
        return this.grandTotalPrice;
    }
}

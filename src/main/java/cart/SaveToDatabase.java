package cart;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import exception.DataAccessException;
import jdbc.JdbcConnectionManager;

@WebServlet(urlPatterns = "/save")
public class SaveToDatabase extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String INSERT = "INSERT into cart_item (cart_number, quantity, total_price, product_number, user_number) VALUES(?, ?, ?, ?, ?)";
    private static final String CHECK = "SELECT quantity, total_price FROM cart_item WHERE product_number = ? ";
    private static final String UPDATE = "UPDATE cart_item SET quantity = ?, total_price = ? WHERE product_number = ?";
    private JdbcConnectionManager connector;
    private Connection conn;
    private PreparedStatement stmt;

    @Override
    public void init() throws ServletException {
        connector = new JdbcConnectionManager();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //HttpSession session = request.getSession(true);
        Cart cart = (Cart) request.getAttribute("cart");

        try {
            conn = connector.getConnection();

            for (CartItem carts : cart.getCartAsList()) {

                stmt = conn.prepareStatement(CHECK);
                stmt.setString(1, carts.getProductNumber());
                ResultSet res = stmt.executeQuery();

                if (res.next()) {
                    int quantity = res.getInt(1);
                    BigDecimal price = res.getBigDecimal(2);
                    stmt = conn.prepareStatement(UPDATE);

                    stmt.setInt(1, quantity + carts.getQuantity());
                    stmt.setBigDecimal(2, price.add(carts.getTotal()));
                    stmt.setString(3, carts.getProductNumber());
                    stmt.executeUpdate();
                } else {
                    stmt = conn.prepareStatement(INSERT);
                    stmt.setString(1, carts.getCartNumber());
                    stmt.setInt(2, carts.getQuantity());
                    stmt.setBigDecimal(3, carts.getTotal());
                    stmt.setString(4, carts.getProductNumber());
                    stmt.setString(5, carts.getUserNumber());
                    stmt.executeUpdate();
                }
            }

            // int rowsInserted =
            // if (rowsInserted > cart.countItems()) {
            // throw new Exception("Inserted rows is greater than cart items");
            // }

        } catch (Exception e) {
            throw new DataAccessException("Error: " + e.getMessage());
        }

        // System.out.println("WIP: SAVE TO DATABASE");
        //
        // for (CartItem item : cart.getCartAsList()) {
        // System.out.println(String.format("ProductNumber=%s || CartNumber = %s
        // || Quantity=%s || ItemTotalPrice=%s || UserNumber=%s",
        // item.getProductNumber(),
        // item.getCartNumber(),
        // item.getQuantity(),
        // item.getTotal(),
        // item.getUserNumber()));
        //
        // }

        RequestDispatcher dispatch = request.getRequestDispatcher("/jsp/Success.jsp");
        dispatch.forward(request, response);

    }

}

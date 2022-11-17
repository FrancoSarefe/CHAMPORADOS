package cart;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
    private JdbcConnectionManager connector;
    private Connection conn;
    private PreparedStatement stmt;

    @Override
    public void init() throws ServletException {
        connector = new JdbcConnectionManager();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        Cart cart = (Cart)session.getAttribute("cart");

        try {
            conn = connector.getConnection();

            for (CartItem carts : cart.getCartAsList()) {
                stmt = conn.prepareStatement(INSERT);
                stmt.setString(1, carts.getCartNumber());
                stmt.setInt(2, carts.getQuantity());
                stmt.setBigDecimal(3, carts.getTotal());
                stmt.setString(4, carts.getProductNumber());
                stmt.setString(5, carts.getUserNumber());
                stmt.executeUpdate();
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

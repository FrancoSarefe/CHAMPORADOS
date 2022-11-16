package cart;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/cartServlet", loadOnStartup = 1)
public class CartServlet extends HttpServlet {
    

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        CartItem cartItem = (CartItem) session.getAttribute("cartItem");
        String action = request.getParameter("action");

        if (cartItem == null) {
            cartItem = new CartItem();
        }
        if (action.equals("add")) {
            Cart cart = this.toCart(request);
            

            cartItem.add(cart);
        } else if (action.equals("remove")) {
            cartItem.remove(request.getParameter("prodNum").trim());
        }
      

        // if (action.equals("save")) {
        // // todo save to database;
        // }
        session.setAttribute("cart", cartItem);
        RequestDispatcher dispatch = request.getRequestDispatcher("/jsp/CartDisplay.jsp");
        dispatch.forward(request, response);
    }

    private Cart toCart(HttpServletRequest request) {
        int iprice = Integer.valueOf(request.getParameter("price").trim());

        int cartNumber = 5;
        int quantity = Integer.valueOf(request.getParameter("quantity").trim());
        BigDecimal totalPrice = BigDecimal.valueOf(iprice * quantity);
        String productNumber = request.getParameter("productNumber");
        String userNumber = "12";

        Cart cart = new Cart();
        cart.setProductNumber(productNumber);
        cart.setCartNumber(cartNumber);
        cart.setQuantity(quantity);
        cart.setTotalPrice(totalPrice);       
        cart.setUserNumber(userNumber);
        return cart;
    }

}

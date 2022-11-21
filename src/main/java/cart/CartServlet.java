package cart;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.LoginFormBean;
import jdbc.JdbcConnectionManager;
import utils.IdGenerator;

@WebServlet(urlPatterns = "/cartServlet", loadOnStartup = 1)
public class CartServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CartRepository cartRepo;
    private CartRepositoryService carting;
    private RequestDispatcher dispatch;
    
    private IdGenerator idGenerator;

    @Override
    public void init() throws ServletException {
    	Connection connection;
		try {
			connection = JdbcConnectionManager.instance().initiate().getConnection();
			cartRepo = new CartRepository(connection);
	        carting = new CartRepositoryService(cartRepo);
	        idGenerator = new IdGenerator(connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        
        List<CartItem> cartList = carting.getCart();
        request.setAttribute("cartDisplay", cartList);
        dispatch = request.getRequestDispatcher("/CartViewing.jsp");
        dispatch.forward(request, response);
        
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        Cart cart = (Cart)session.getAttribute("cart");
        String action = request.getParameter("action");

        if (cart == null) {
            cart = new Cart();
        }
        if (action.equals("add")) {
            CartItem cartItem = this.toCartItem(request, session);
            cart.add(cartItem);

            session.setAttribute("cart", cart);
            dispatch = request.getRequestDispatcher("/Cart.jsp");
            dispatch.forward(request, response);
        } else if (action.equals("remove")) {
            cart.remove(request.getParameter("prodNum"));

            session.setAttribute("cart", cart);
            dispatch = request.getRequestDispatcher("/Cart.jsp");
            dispatch.forward(request, response);
        } else if (action.equals("save")) {
            
            request.setAttribute("cart", cart);
            dispatch = request.getRequestDispatcher("/save");
            dispatch.forward(request, response);
            
        } else if (action.equals("delete")) {
            String temp = (String) request.getParameter("Numb");
            System.out.println(temp);
            int prodNum = Integer.valueOf(temp.trim());
            cartRepo.remove(prodNum);
            doGet(request, response);

        }

    }

    private CartItem toCartItem(HttpServletRequest request, HttpSession session) {
    	
        String proNum = request.getParameter("prodNum");
        String cartNum = idGenerator.generateId("Cart_Item");
//        int quantity = Integer.valueOf(request.getParameter("quantity").trim());
        int tempPrice = Integer.valueOf(request.getParameter("price").trim());

        BigDecimal price = BigDecimal.valueOf(tempPrice);
        
        LoginFormBean loginFormBean = (LoginFormBean) session.getAttribute("loginFormBean");

        String walletNum = loginFormBean.getWalletNumber();

        CartItem cartItem = new CartItem();
        cartItem.setPrice(price);

        cartItem.setProductNumber(proNum);
        cartItem.setCartNumber(cartNum);
        cartItem.setQuantity(1);
        cartItem.getTotal();
        cartItem.setWalletNumber(walletNum);

        return cartItem;

    }

}

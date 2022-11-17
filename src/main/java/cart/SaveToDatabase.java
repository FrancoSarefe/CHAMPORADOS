package cart;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(urlPatterns = "/save")
public class SaveToDatabase extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    HttpSession session = request.getSession(true);
		Cart cart = (Cart) session.getAttribute("cart");
		
		System.out.println("WIP: SAVE TO DATABASE");
		
		for(CartItem item : cart.getCartAsList()) {
            System.out.println(String.format("%s, %s, %s, %s, %s", item.getProductNumber(), item.getCartNumber(), item.getQuantity(), item.getTotal(), item.getUserNumber()));
            
        }
		
		RequestDispatcher dispatch = request.getRequestDispatcher("/jsp/Success.jsp");
		dispatch.forward(request, response);
		
		
	}

}

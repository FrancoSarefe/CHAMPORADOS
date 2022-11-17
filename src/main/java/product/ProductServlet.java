package product;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.JdbcConnectionManager;
@WebServlet(urlPatterns = "/productServlet")
public class ProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ProductRepository repos;
    private ProductService prodService;

    @Override
    public void init() throws ServletException {
       
        repos = new ProductRepository();
        prodService = new ProductService(repos);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        final List<Product> productList = prodService.getProduct();
        request.setAttribute("productlist", productList);
        RequestDispatcher dispatch = request.getRequestDispatcher("/jsp/DisplayProduct.jsp");
        dispatch.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}

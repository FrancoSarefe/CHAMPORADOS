package action;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Product;
import enums.ProductCategory;
import repository.ProductRepository;
import service.ProductCatalogService;



public class ProductCatalogAction implements Action {

	private final ProductRepository productRepository;
	private final ProductCatalogService productCatalogService;

	public ProductCatalogAction() {

		productRepository = new ProductRepository();
		productCatalogService = new ProductCatalogService(productRepository);
	}

	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println(request.getServletPath());

		if (request.getParameter("action").equals("add")) {
			
			productCatalogService.insertProduct(this.fetchProductDetails(request));

			return fetchProduct(ProductCategory.DISPLAY, request, "add");

		} else if (request.getParameter("action").equals("delete")) {

			productCatalogService.deleteProduct(request.getParameter("productNumberDelete"));

			return fetchProduct(ProductCategory.DISPLAY, request, "delete");

		} else if (request.getParameter("action").equals("update")) {

			
			productCatalogService.updateProduct(request.getParameter("productNumberUpdate"),
					this.fetchProductDetails(request));

			return fetchProduct(ProductCategory.DISPLAY, request, "update");

		} else if (request.getParameter("action").equals("display")) {}
		
		
		ProductCategory category = ProductCategory.DISPLAY;
		
		if (request.getParameter("filterByCategory") != null) {

			switch (request.getParameter("filterByCategory")) {
			
			case "Breakfast":
				category = ProductCategory.BREAKFAST;
				break;
				
			case "Lunch":
				category = ProductCategory.LUNCH;
				break;

			case "Snacks":
				category = ProductCategory.SNACKS;
				break;

			}

		}
		return fetchProduct(category, request, "display");

	}
	
	
	public String fetchProduct(ProductCategory category, ServletRequest request, String action) {

		List<Product> products = null; 
		
		if(request.getParameter("searchProduct") != null) {
			
			products = productCatalogService.getProductCatalog(category, request.getParameter("searchProduct"));
			
		}else {
			
			products = productCatalogService.getProductCatalog(category, null);
		}
	
		
		request.setAttribute("product", products);
		request.setAttribute("action", action);
		request.setAttribute("category", category.toString());
		return "/product.jsp";
	}

	private Product fetchProductDetails(HttpServletRequest request) {

		Product product = new Product();
		product.setProductName(request.getParameter("product_Name"));
		product.setDescription(request.getParameter("product_Description"));
		product.setPrice(new BigDecimal(request.getParameter("product_Price")));
		product.setQuantity(new BigDecimal(request.getParameter("product_Quantity")));
		product.setCategory(request.getParameter("product_Category"));
		return product;

	}

}

package repository;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Product;
import enums.ProductCategory;
import exception.DataAccessException;
import jdbc.JdbcConnectionManager;
import utils.IdGenerator;

public class ProductRepository {

	private final static String FETCH_ALL_PRODUCTS = "SELECT * FROM CHAMP_PRODUCT ORDER BY product_number ASC";
	//private final static String FIND_PRODUCT = FETCH_ALL_PRODUCTS + " WHERE product_number = ?";
	//private final static String UPDATE_PRODUCT = "UPDATE CHAMP_PRODUCT SET product_name = ?, description = ?, price = ?, quantity = ?, category = ? WHERE product_number = ?";
	private final static String ADD_PRODUCT = "INSERT INTO CHAMP_PRODUCT(product_number, product_name, description, price, quantity, category) VALUES (?,?,?,?,?,?)";
	private final static String DELETE_PRODUCT = "DELETE FROM CHAMP_PRODUCT WHERE product_number = ?";
	private final static String GENERATE_PRODUCT_NUMBER = "SELECT product_number FROM CHAMP_PRODUCT WHERE id = (SELECT MAX(id) FROM CHAMP_PRODUCT)";
	
	
	
	private Connection connection;
	private IdGenerator idGenerator;

	public ProductRepository() {

		try {
			connection = JdbcConnectionManager.instance().initiate().getConnection();
		} catch (SQLException e) {
			throw DataAccessException.instance("FAILED TO CONNECT DATABASE(PRODUCT REPOSITORY)! " + e.getMessage());
		}
	}

	public List<Product> findAll(ProductCategory category, String searchValue) {

		try {
			
			final PreparedStatement fetchAllProduct = fetchProductByCategoryOrSearch(category, searchValue);
			
			final List<Product> products = new ArrayList<>();
			final ResultSet resultSet = fetchAllProduct.executeQuery();

			while (resultSet.next()) {

				Product product = new Product(resultSet.getString(2), resultSet.getString(3), resultSet.getString(4),
						resultSet.getBigDecimal(5), resultSet.getBigDecimal(6), resultSet.getString(7));
				products.add(product);
			}

			return products;

		} catch (Exception e) {
			throw DataAccessException.instance("FAILED TO FETCH PRODUCTS! " + e.getMessage());
		}
	}
	
	private PreparedStatement fetchProductByCategoryOrSearch(ProductCategory category, String searchValue) {
		
		PreparedStatement fetchAllProduct = null;
		
		String productCategory = category.toString().toUpperCase();
		String FETCH_ALL_PRODUCTS_CATEGORY = "SELECT * FROM CHAMP_PRODUCT WHERE UPPER(category) = '" + productCategory + "' ORDER BY product_number ASC";
		String FETCH_ALL_PRODUCTS_SEARCH = "SELECT * FROM CHAMP_PRODUCT WHERE product_number = '" + searchValue + "' ORDER BY product_number ASC";
		
		if(category != ProductCategory.DISPLAY) {
			
			try {
				fetchAllProduct = connection.prepareStatement(FETCH_ALL_PRODUCTS_CATEGORY);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}else {
			
			
			if(searchValue != null) {
				
				try {
					fetchAllProduct = connection.prepareStatement(FETCH_ALL_PRODUCTS_SEARCH);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				
			}else {
				

				try {
					fetchAllProduct = connection.prepareStatement(FETCH_ALL_PRODUCTS);
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
		}
		
		return fetchAllProduct;
		
		
	}

	public boolean addProduct(Product product) {

		try {

			final PreparedStatement addProduct = connection.prepareStatement(ADD_PRODUCT);
			idGenerator = new IdGenerator(connection);
			addProduct.setString(1, idGenerator.generateId("Product"));
			addProduct.setString(2, product.getProductName());
			addProduct.setString(3, product.getDescription());
			addProduct.setBigDecimal(4, product.getPrice());
			addProduct.setBigDecimal(5, product.getQuantity());
			addProduct.setString(6, product.getCategory());

			addProduct.executeUpdate();

			return true;

		} catch (Exception e) {
			throw DataAccessException.instance("FAILED TO ADD PRODUCTS! " + e.getMessage());
		}

	}

//	public String productNumberGenerator() {
//
//		try {
//			
//			StringBuilder stringBuilder = new StringBuilder();
//			Integer count = null;
//
//			final PreparedStatement generate = connection.prepareStatement(GENERATE_PRODUCT_NUMBER);
//			final ResultSet resultSet = generate.executeQuery();
//			stringBuilder.append("chmP-");
//			
//			if(resultSet.next()) {
//
//				count = Integer.parseInt(resultSet.getString(1).split("-")[1]) + 1;
//			}else {
//				count = 1;
//            	
//            }
//			
//			stringBuilder.append(count.toString());
//			return stringBuilder.toString();
//
//		} catch (Exception e) {
//			throw DataAccessException.instance("FAILED TO GENERATE PRODUCT NUMBER! " + e.getMessage());
//		}
//
//	}


	public boolean deleteProduct(String product_Number) {

		try {

			final PreparedStatement deleteProduct = connection.prepareStatement(DELETE_PRODUCT);
			deleteProduct.setString(1, product_Number);

			deleteProduct.executeUpdate();

			return true;

		} catch (Exception e) {
			throw DataAccessException.instance("FAILED TO DELETE PRODUCTS! " + e.getMessage());
		}

	}
	
	
	public boolean updateProduct(String productNumber, Product product) {

		try {
			
			String product_name = product.getProductName();
			String description = product.getDescription();
			BigDecimal price = product.getPrice();
			BigDecimal quantity = product.getQuantity();
			String category = product.getCategory();
			
			
			String UPDATE_PRODUCT = "UPDATE CHAMP_PRODUCT SET product_name = '" + product_name + "', description = '" + description + "', price = " + price + ", quantity = " + quantity + ", category = '" + category + "' WHERE product_number = '" + productNumber + "'";
			
			final PreparedStatement updateProduct = connection.prepareStatement(UPDATE_PRODUCT);
			updateProduct.executeUpdate();

			return true;

		} catch (Exception e) {
			throw DataAccessException.instance("FAILED TO UPDATE PRODUCTS! " + e.getMessage());
		}

	}
	
	/*
	public Product getProductDetailsToUpdate(String product_Number) {

		try {
			
			Product product = null;
			final PreparedStatement productDetails = connection.prepareStatement(FIND_PRODUCT);
			productDetails.setString(1, product_Number);
			final ResultSet resultSet = productDetails.executeQuery();

			if(resultSet.next()) {

					product = new Product(resultSet.getString(2), resultSet.getString(3), resultSet.getString(4),
						resultSet.getBigDecimal(5), resultSet.getBigDecimal(6), resultSet.getString(7));
					
			}
			return product;


		} catch (Exception e) {
			throw DataAccessException.instance("FAILED TO FETCH PRODUCT DETAILS! " + e.getMessage());
		}

	}*/

}

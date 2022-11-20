package service;

import java.util.List;

import entity.Product;
import enums.ProductCategory;
import exception.DataAccessException;
import exception.ServiceException;
import repository.ProductRepository;

public class ProductCatalogService {
	
    private ProductRepository productRepository;

    public ProductCatalogService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProductCatalog(ProductCategory category, String searchValue) {
        try {
            return productRepository.findAll(category, searchValue);
        } catch (DataAccessException e) {
            throw ServiceException.instance(e.getMessage());
        }

    }
    
    public boolean insertProduct(Product product) {
		
		try {
		
			return productRepository.addProduct(product);
            
		} catch (DataAccessException e) {
			  throw ServiceException.instance(e.getMessage());
		} 

	}
    
    public boolean deleteProduct(String product_Number) {
		
		try {
			
			return productRepository.deleteProduct(product_Number);
            
		} catch (Exception e) {
			
			  throw ServiceException.instance(e.getMessage());
		} 

	}
    
    public boolean updateProduct(String productNumber, Product product) {
		
 		try {
 		
 			return productRepository.updateProduct(productNumber, product);
             
 		} catch (DataAccessException e) {
 			  throw ServiceException.instance(e.getMessage());
 		} 

 	}
    
    
    /*
    public Product fetchProductToUpdate(String product_Number) {
		
		try {
			
			return productRepository.getProductDetailsToUpdate(product_Number);
            
		} catch (Exception e) {
			
			  throw ServiceException.instance(e.getMessage());
		} 

	}*/

}

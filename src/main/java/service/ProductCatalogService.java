package service;

import java.util.List;

import entity.Product;
import exception.DataAccessException;
import exception.ServiceException;
import repository.ProductRepository;

public class ProductCatalogService {
	
    private ProductRepository productRepository;

    public ProductCatalogService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProductCatalog() {
        try {
            return productRepository.findAll();
        } catch (DataAccessException e) {
            throw ServiceException.instance(e.getMessage());
        }

    }

}

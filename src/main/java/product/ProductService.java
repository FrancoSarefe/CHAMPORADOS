package product;

import java.util.List;

import exception.DataAccessException;
import exception.ServiceException;

public class ProductService {
    private ProductRepository repos;

    public ProductService(ProductRepository repos) {
        this.repos = repos;
    }

    public List<Product> getProduct() {
        try {
            return repos.listAll();
        } catch (DataAccessException e) {
            throw ServiceException.instance(e.getMessage());
        }
    }
}

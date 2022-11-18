package cart;

import java.util.List;

import exception.DataAccessException;
import exception.ServiceException;

public class CartRepositoryService {
    private CartRepository cartRepo;

    public CartRepositoryService(CartRepository cartRepo) {
        super();
        this.cartRepo = cartRepo;
    }

    public List<CartItem> getCart() {
        try {
            return cartRepo.listall();
        } catch (DataAccessException e) {
            throw ServiceException.instance(e.getMessage());
        }
    }
    
    public List<CartItem> getCartByWallet(String wallet) {
        try {
            return cartRepo.listByWalletNumber(wallet);
        } catch (DataAccessException e) {
            throw ServiceException.instance(e.getMessage());
        }
    }

}

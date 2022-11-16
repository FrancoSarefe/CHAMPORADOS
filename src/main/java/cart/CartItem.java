package cart;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CartItem {
    private Map<String, Cart> cart;

    public CartItem() {
        cart = new HashMap<>();
    }

    public int countCartItems() {
        return cart.size();
    }

    public void add(Cart item) {
        if (item == null) {
            throw new IllegalArgumentException("Cart cannot be null");
        }
        String prodNum = item.getProductNumber().trim();
        
        if (cart.containsKey(prodNum)) {
            cart.get(prodNum).incrementQuantity();
           
           
        } else {
            cart.put(prodNum, item);
            System.out.println("add");
           
        }
    }

    public void remove(String productNumber) {
        Cart item = cart.get(productNumber);
        if (item == null) {
            throw new IllegalArgumentException("Product not found");
        }
        cart.remove(productNumber.trim());

    }

    public Map<String, Cart> getProduct() {
        return cart;
    }

    public List<Cart> getProductAsList() {
        return new ArrayList<>(cart.values());
    }

    public BigDecimal cartTotal() {
        List<Cart> cartItemPrice = new ArrayList<>(cart.values());
        BigDecimal total = new BigDecimal(0);
        for (Cart item : cartItemPrice) {
            total = total.add(item.getTotalPrice());
        }
        return total;
    }

}

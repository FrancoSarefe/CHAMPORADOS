package cart;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cart {
    private Map<String, CartItem> items;

    public Cart() {
        items = new HashMap<>();
    }
    
    public int countItems() {
        return items.size();
    }

    public void add(CartItem item) {
        if (item == null) {
            throw new IllegalArgumentException("What are you adding to cart?");
        }
        String prodNum = item.getProductNumber().trim();

        if (items.containsKey(prodNum)) {
            items.get(prodNum).incrementQuantity();
            items.get(prodNum).getTotal();
        } else {
            items.put(prodNum, item);
        }
    }

    public void remove(String prodNum) {
        CartItem item = items.get(prodNum.trim());
        if (item == null) {
            throw new RuntimeException("Item does not exist");
        }
        items.remove(prodNum.trim());
    }

    public Map<String, CartItem> getItems() {
        return items;
    }

    public List<CartItem> getCartAsList() {
        return new ArrayList<>(items.values());
    }
    
    public BigDecimal getGrandTotal() {
        List<CartItem> prices = new ArrayList<>(items.values());
        BigDecimal totality = new BigDecimal(0);
        for(CartItem price: prices) {
            totality = totality.add(price.getTotal());
        }
        return totality;
    }

}

package cart;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class CartItem {
    private String productNumber;
    private String cartNumber;
    private int quantity;
    private BigDecimal totalPrice;
    private BigDecimal price;
    private String userNumber;

    public CartItem(String cartNumber, int quantity, BigDecimal totalPrice, String productNumber, String userNumber) {
        super();
        this.productNumber = productNumber;
        this.cartNumber = cartNumber;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.userNumber = userNumber;
    }

    public BigDecimal getTotal() {
        return this.totalPrice = this.price.multiply(BigDecimal.valueOf(this.quantity));
    }

    public void incrementQuantity() {
        this.quantity += 1;
    }

}

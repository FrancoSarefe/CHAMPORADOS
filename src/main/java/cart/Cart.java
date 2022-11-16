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
public class Cart {
    private String productNumber;
    private int cartNumber;
    private int quantity;
    private BigDecimal totalPrice;
    private String userNumber;

    public void incrementQuantity() {
        this.quantity += 1;
    }
}

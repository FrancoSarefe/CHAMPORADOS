package entity;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private String productNumber;
    private String productName;
    private String description;
    private BigDecimal price;
    private BigDecimal quantity;
    private String category;
    //private Blob image;
}

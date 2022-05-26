package domain;

import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ProdCatResult {
    private Integer id;
    private String name;
    private BigDecimal price;
    private Integer categoryId;
    private String categoryName;
}

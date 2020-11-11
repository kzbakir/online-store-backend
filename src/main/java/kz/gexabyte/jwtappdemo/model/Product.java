package kz.gexabyte.jwtappdemo.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "product")
@Data
public class Product extends BaseEntity {

    @Column(name = "product_name_ru")
    private String productNameRu;

    @Column(name = "product_name_eng")
    private String productNameEng;

    @Column(name = "product_description_ru")
    private String productDescriptionRu;

    @Column(name = "product_description_eng")
    private String productDescriptionEng;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "in_stock")
    private boolean inStock;
}

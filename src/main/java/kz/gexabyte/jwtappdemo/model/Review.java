package kz.gexabyte.jwtappdemo.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "review")
@Data
public class Review extends BaseEntity {

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "raiting")
    private Integer raiting;

    @Column(name = "text")
    private String reviewText;

    @OneToMany(mappedBy = "review")
    private List<Product> products;
}

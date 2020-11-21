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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinTable(name = "product_review",
            joinColumns = {@JoinColumn(name = "review_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "product_id", referencedColumnName = "id")})
    private Product product;

    @Column(name = "raiting")
    private Integer raiting;

    @Column(name = "text")
    private String reviewText;
}

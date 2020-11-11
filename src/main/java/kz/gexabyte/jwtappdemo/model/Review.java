package kz.gexabyte.jwtappdemo.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "review")
@Data
public class Review extends BaseEntity{

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "raiting")
    private Integer raiting;

    @Column(name = "text")
    private String reviewText;

}

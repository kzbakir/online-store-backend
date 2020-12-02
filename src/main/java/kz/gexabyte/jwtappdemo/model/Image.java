package kz.gexabyte.jwtappdemo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "image")
@Data
public class Image extends BaseEntity {

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnore
    @JoinTable(name = "product_image",
            joinColumns = {@JoinColumn(name = "image_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "product_id", referencedColumnName = "id")})
    private Product product;

    @Column(name = "name")
    private String imageName;

    @Column(name = "path")
    private String path;
}

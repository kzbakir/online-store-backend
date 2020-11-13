package kz.gexabyte.jwtappdemo.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "image")
@Data
public class Image extends BaseEntity {

    @OneToMany(mappedBy = "image")
    private List<Product> products;

    @Column(name = "name")
    private String imageName;

    @Column(name = "path")
    private String path;
}

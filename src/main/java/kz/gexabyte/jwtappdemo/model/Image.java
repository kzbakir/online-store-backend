package kz.gexabyte.jwtappdemo.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Blob;

@Entity
@Table(name = "image")
@Data
public class Image extends BaseEntity{

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "name")
    private String imageName;

    @Column(name = "path")
    private String path;
}

package kz.gexabyte.jwtappdemo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "product")
@Data
public class Product extends BaseEntity {

    @Column(name = "name_ru")
    private String nameRu;

    @Column(name = "name_eng")
    private String nameEng;

    @Column(name = "description_ru")
    private String descriptionRu;

    @Column(name = "description_eng")
    private String descriptionEng;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "weight")
    private String weight;

    @Column(name = "height")
    private String height;

    @Column(name = "width")
    private String width;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "brand_id", referencedColumnName = "id")
    private Brand brand;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "manufacturer_country_id", referencedColumnName = "id")
    private Country manufacturerCountry;

    @Column(name = "series_ru")
    private String seriesRu;

    @Column(name = "series_eng")
    private String seriesEng;

    @Column(name = "color_ru")
    private String colorRu;

    @Column(name = "color_eng")
    private String colorEng;

    @Column(name = "shelf_life")
    private Integer shelfLife;

    @Column(name = "guarantee")
    private Integer guarantee;

    @Column(name = "amount")
    private Integer amount;

    @OneToMany(mappedBy = "product")
    private List<Review> reviews;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnore
    @JoinTable(name = "product_order",
            joinColumns = {@JoinColumn(name = "product_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "order_id", referencedColumnName = "id")})
    private Order order;

    @OneToMany(mappedBy = "product")
    private List<Image> images;

    @OneToMany(mappedBy = "product")
    private List<UnderCategory> underCategories;
}

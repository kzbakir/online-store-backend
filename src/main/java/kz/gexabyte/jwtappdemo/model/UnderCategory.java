package kz.gexabyte.jwtappdemo.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "under_category")
@Data
public class UnderCategory extends BaseEntity {

    @Column(name = "name_ru")
    private String nameRu;

    @Column(name = "name_eng")
    private String nameEng;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinTable(name = "product_category",
            joinColumns = {@JoinColumn(name = "product_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "under_category_id", referencedColumnName = "id")})
    private Product product;
}

package kz.gexabyte.jwtappdemo.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "product_country")
@Data
public class Country extends BaseEntity {

    @Column(name = "name_ru")
    private String nameRu;

    @Column(name = "name_eng")
    private String nameEng;

    @OneToOne(mappedBy = "brandCountry")
    private Product productBrand;

    @OneToOne(mappedBy = "manufacturerCountry")
    private Product productManufacturer;
}

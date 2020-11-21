package kz.gexabyte.jwtappdemo.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "country")
@Data
public class Country extends BaseEntity {

    @Column(name = "name_ru")
    private String nameRu;

    @Column(name = "name_eng")
    private String nameEng;

    @OneToOne(mappedBy = "brandCountry")
    private Brand brand;

    @OneToOne(mappedBy = "manufacturerCountry")
    private Product productManufacturer;
}

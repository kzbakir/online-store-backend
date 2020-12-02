package kz.gexabyte.jwtappdemo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "country")
@Data
public class Country extends BaseEntity {

    @Column(name = "name_ru")
    private String nameRu;

    @Column(name = "name_eng")
    private String nameEng;

    @OneToOne(mappedBy = "brandCountry")
    @JsonIgnore
    private Brand brand;

    @OneToOne(mappedBy = "manufacturerCountry")
    @JsonIgnore
    private Product productManufacturer;
}

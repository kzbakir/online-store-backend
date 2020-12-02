package kz.gexabyte.jwtappdemo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "brand")
@Data
public class Brand extends BaseEntity {
    @Column(name = "name")
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "country_id")
    @JsonIgnore
    private Country brandCountry;

    @JsonIgnore
    @OneToOne(mappedBy = "brand")
    private Product product;

}

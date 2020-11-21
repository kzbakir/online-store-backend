package kz.gexabyte.jwtappdemo.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "brand")
@Data
public class Brand extends BaseEntity{
    @Column(name = "name")
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "country_id", referencedColumnName = "id")
    private Country brandCountry;

    @OneToOne(mappedBy = "brand")
    private Product product;
}

package kz.gexabyte.jwtappdemo.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "brand")
@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Brand extends BaseEntity{
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

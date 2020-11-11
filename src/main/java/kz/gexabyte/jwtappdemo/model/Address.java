package kz.gexabyte.jwtappdemo.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "address")
@Data
public class Address extends BaseEntity {

    @Column(name = "city")
    private String city;

    @Column(name = "street")
    private String street;

    @Column(name = "house_number")
    private String houseNumber;

    @Column(name = "apartment_number")
    private Integer apartmentNumber;

    @OneToOne(mappedBy = "address")
    private User user;
}

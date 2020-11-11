package kz.gexabyte.jwtappdemo.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "storage")
@Data
public class Storage extends BaseEntity{

    @Column(name = "name")
    private String nameStorage;

    @Column(name = "description")
    private String descriptionStorage;

}

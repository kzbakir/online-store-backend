package kz.gexabyte.jwtappdemo.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "category")
@Data
public class Category extends BaseEntity {

    @Column(name = "name_ru")
    private String categoryNameRu;

    @Column(name = "name_eng")
    private String categoryNameEng;
}

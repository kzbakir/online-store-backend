package kz.gexabyte.jwtappdemo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "category")
@Data
public class Category extends BaseEntity {

    @Column(name = "name_ru")
    private String nameRu;

    @Column(name = "name_eng")
    private String nameEng;

    @OneToMany(mappedBy = "category")
    @JsonIgnore
    private List<UnderCategory> underCategories;
}

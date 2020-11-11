package kz.gexabyte.jwtappdemo.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "storage_item")
@Data
public class StorageItem extends BaseEntity {

    @Column(name = "storage_id")
    private Long storageId;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "amount")
    private Integer amount;
}

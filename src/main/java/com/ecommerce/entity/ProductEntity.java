package com.ecommerce.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "PRODUCT")
public class ProductEntity extends BaseExtendModel{
    private String name;
    private BigDecimal price;
    private UUID barcode;
    private String image;

    @ManyToOne(cascade = CascadeType.ALL)
    private BrandEntity   brand;

    @ManyToOne(cascade = CascadeType.ALL)
    private CategoryEntity category;
}

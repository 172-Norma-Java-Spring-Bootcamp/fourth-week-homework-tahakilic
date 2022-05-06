package com.ecommerce.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "BASKET")
public class BasketEntity extends BaseModel {
    @Column(nullable = false)
    private BigDecimal price;

    private BigDecimal discountPrice = BigDecimal.ZERO;
    private BigDecimal taxPrice = BigDecimal.ZERO;
    private BigDecimal shippingPrice = BigDecimal.ZERO;
    @Column(nullable = false)
    private BigDecimal totalPrice;

    @OneToMany(mappedBy = "basket")
    private Set<BasketItemEntity> items = new HashSet<>();
}

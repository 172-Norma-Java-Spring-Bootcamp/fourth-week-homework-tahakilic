package com.ecommerce.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "CATEGORY")
public class CategoryEntity extends BaseModel {
    @OneToOne(cascade=CascadeType.ALL)
    private CategoryEntity parent;
    private String name;
}

package com.ecommerce.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "BRAND")
public class BrandEntity extends BaseModel{
    private String name;
}

package com.ecommerce.entity;

import lombok.Getter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Getter
@MappedSuperclass   //Entity olmayan superclasstan inherit edilebilir.
                    //Ortak entity özelliği olduğunda kullanılır.
                    //@Entity anotasyonu kullanılmaz
public abstract class BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}

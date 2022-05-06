package com.ecommerce.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name ="CUSTOMER" )
public class CustomerEntity extends BaseExtendModel {
    private String username;
    private String email;
    private Long identity;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String password;
    private Boolean isDeleted=false;

    @OneToOne( mappedBy = "customer",cascade = CascadeType.ALL)
    private CustomerAddressEntity customerAddress;
}

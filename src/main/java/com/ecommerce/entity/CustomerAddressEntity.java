package com.ecommerce.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Setter
@Getter
@Table(name ="CUSTOMER_ADDRESS" )
public class CustomerAddressEntity extends BaseModel {
    private String phoneNumber;
    private String country;
    private String city;
    private String postalCode;
    private String description;

    @OneToOne
    @JsonIgnore     //Burada kod sonsuz döngüye giriyor. Ignore ederek bu alanı göstermiyoruz.
    private CustomerEntity customer;
}

package com.ecommerce.core.model.dto;

import com.ecommerce.entity.CustomerAddressEntity;
import com.ecommerce.entity.Gender;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class CustomerDTO{
    private String userName;
    private String email;
    private Long identity;
    private Gender gender;
    private String password;
    private CustomerAddressEntity customerAddress;
}

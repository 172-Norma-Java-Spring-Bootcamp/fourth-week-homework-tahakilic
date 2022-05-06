package com.ecommerce.core.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CustomerAddressDTO {
    private String phoneNumber;
    private String country;
    private String city;
    private String postalCode;
    private String description;
}

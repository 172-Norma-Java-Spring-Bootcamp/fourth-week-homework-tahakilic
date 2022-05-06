package com.ecommerce.core.model.response;

import com.ecommerce.core.model.dto.CustomerAddressDTO;
import com.ecommerce.entity.Gender;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CustomerResponse {
    private String username;
    private String email;
    private Gender gender;
    private CustomerAddressDTO customerAddress;
}

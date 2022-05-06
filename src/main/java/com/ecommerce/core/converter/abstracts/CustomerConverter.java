package com.ecommerce.core.converter.abstracts;

import com.ecommerce.core.model.dto.CustomerDTO;
import com.ecommerce.core.model.response.CustomerResponse;
import com.ecommerce.entity.CustomerEntity;

import java.util.List;

public interface CustomerConverter {
    CustomerEntity convertCreate(CustomerDTO customerDTO);

    CustomerResponse convertGetById(CustomerEntity customerEntity);

   CustomerEntity convertUpdate(CustomerEntity customerEntity, CustomerDTO customerDTO);

    List<CustomerResponse> convertGetAll(List<CustomerEntity> allCustomer);


}

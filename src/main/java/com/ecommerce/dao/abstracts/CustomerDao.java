package com.ecommerce.dao.abstracts;

import com.ecommerce.core.model.dto.CustomerDTO;
import com.ecommerce.core.model.response.CustomerResponse;
import com.ecommerce.entity.CustomerEntity;

import java.util.List;

public interface CustomerDao {
    CustomerEntity create(CustomerEntity customerEntity);

    CustomerEntity getCustomerById(Long id);

    CustomerEntity update(CustomerEntity customerNew);

    List<CustomerEntity> getAllCustomer();

    int deleteById(Long id);
}

package com.ecommerce.service.abstracts;

import com.ecommerce.core.model.dto.CustomerDTO;
import com.ecommerce.core.model.response.CustomerResponse;
import com.ecommerce.entity.CustomerEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CustomerService {
    void create(CustomerDTO customerDTO);

    CustomerResponse getCustomerById(Long id);

    void update(Long id, CustomerDTO customerDTO);

    List<CustomerResponse> getAllCustomer();

    String deleteById(Long id);
}

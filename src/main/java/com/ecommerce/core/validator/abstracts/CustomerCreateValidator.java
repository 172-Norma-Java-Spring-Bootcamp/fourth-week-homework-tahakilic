package com.ecommerce.core.validator.abstracts;

import com.ecommerce.core.exception.BaseException;
import com.ecommerce.core.model.dto.CustomerDTO;

public interface CustomerCreateValidator {
    void validate(CustomerDTO customerDTO) throws BaseException;
}

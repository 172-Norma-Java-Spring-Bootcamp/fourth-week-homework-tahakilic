package com.ecommerce.core.validator.concretes;

import com.ecommerce.core.exception.BaseException;
import com.ecommerce.core.exception.ControllerOperationException;
import com.ecommerce.core.validator.abstracts.IdValidator;
import org.springframework.stereotype.Component;

@Component
public class IdValidatorImpl implements IdValidator {
    @Override
    public void customerIdValidator(Long id) throws BaseException {
        if (id < 0) {
            throw new ControllerOperationException.CustomerIdNotValidException("Customer ID should be greater than zero.");
        }
    }
}

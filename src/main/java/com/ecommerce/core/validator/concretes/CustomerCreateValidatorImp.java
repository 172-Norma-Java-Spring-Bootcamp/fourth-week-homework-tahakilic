package com.ecommerce.core.validator.concretes;

import com.ecommerce.core.exception.BaseException;
import com.ecommerce.core.exception.ControllerOperationException;
import com.ecommerce.core.model.dto.CustomerDTO;
import com.ecommerce.core.validator.abstracts.CustomerCreateValidator;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Objects;

@Component
public class CustomerCreateValidatorImp implements CustomerCreateValidator {
    @Override
    public void validate(CustomerDTO customerDTO) throws BaseException {
        if(Objects.isNull(customerDTO)){
            throw new ControllerOperationException.CustomerNotValidException("Customer can not be null or empty");
        }
        if(!(StringUtils.hasLength(customerDTO.getUserName()))){
            throw new ControllerOperationException.CustomerNotValidException("Customer username  not be null or empty");

        }
        if(!(StringUtils.hasLength(customerDTO.getPassword()))){
            throw new ControllerOperationException.CustomerNotValidException("Customer password  not be null or empty");

        }
        if(Objects.isNull(customerDTO.getIdentity())){
            throw new ControllerOperationException.CustomerNotValidException("Customer identity  not be null or empty");

        }
        if(Objects.isNull(customerDTO.getGender())){
            throw new ControllerOperationException.CustomerNotValidException("Customer gender  not be null or empty");

        }

    }
}

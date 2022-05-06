package com.ecommerce.core.exception;

public class DaoOperationException {

    public static class CustomerNotFoundException extends BaseException{
        public CustomerNotFoundException(String message) {
            super(message);
        }
    }

}

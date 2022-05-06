package com.ecommerce.core.exception;

public class ControllerOperationException {
    public ControllerOperationException() {
    }

    public static class CustomerNotValidException extends BaseException{

        public CustomerNotValidException(String message){
            super(message);
        }
    }

    public static class CustomerIdNotValidException extends BaseException{
        public CustomerIdNotValidException(String message){
            super(message);
        }
    }
}

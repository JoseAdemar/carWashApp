package com.carwashapp.backend.customer.exception;

public class NullCustomerException extends RuntimeException {
    public NullCustomerException(String message) {
        super(message);
    }
}

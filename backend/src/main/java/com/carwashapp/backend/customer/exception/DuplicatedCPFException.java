package com.carwashapp.backend.customer.exception;

public class DuplicatedCPFException extends RuntimeException {

    public DuplicatedCPFException(String message) {
        super(message);
    }
}

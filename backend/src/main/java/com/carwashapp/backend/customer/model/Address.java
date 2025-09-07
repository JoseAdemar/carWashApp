package com.carwashapp.backend.customer.model;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class Address {
    private String zipCode;
    private String city;
    private String street;
    private String state;
}

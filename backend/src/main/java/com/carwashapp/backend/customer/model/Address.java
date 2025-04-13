package com.carwashapp.backend.customer.model;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class Address {

    @Pattern(regexp = "\\d{5}-\\d{3}", message = "Zip code must be in the format XXXXX-XXX")
    private String zipCode;

    @NotBlank(message = "City cannot be empty")
    private String city;

    @NotBlank(message = "Street cannot be empty")
    private String street;

    @NotBlank(message = "State cannot be empty")
    private String state;
}

package com.carwashapp.backend.customer.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record AddressDTO(
        @Pattern(regexp = "\\d{5}-\\d{3}", message = "Zip code must be in the format XXXXX-XXX")
        String zipCode,
        @NotBlank(message = "City cannot be empty")
        @Size(min = 2, max = 100, message = "City name must be between 2 and 100 characters")
        String city,
        @NotBlank(message = "Street cannot be empty")
        String street,
        @NotBlank(message = "State cannot be empty")
        String state
) {

}
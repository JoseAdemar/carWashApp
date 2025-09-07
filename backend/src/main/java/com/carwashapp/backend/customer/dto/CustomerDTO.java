package com.carwashapp.backend.customer.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CPF;

public record CustomerDTO(
        Long id,
        @NotBlank(message = "Name cannot be empty or just spaces")
        String name,
        @Email(message = "Email should be valid")
        @Size(min = 5, message = "Email is too short")
        String email,
        @Pattern(regexp = "\\d{11}", message = "CPF must have 11 digits")
        @CPF(message = "Invalid CPF")
        String cpf,
        @Pattern(regexp = "\\(\\d{2}\\) \\d{5}-\\d{4}", message = "Phone number must be in the format (XX) XXXXX-XXXX")
        String phoneNumber,
        AddressDTO address
) {

}

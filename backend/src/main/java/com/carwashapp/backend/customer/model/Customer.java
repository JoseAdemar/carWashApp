package com.carwashapp.backend.customer.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Embedded;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Customer {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name cannot be empty or just spaces")
    private String nome;

    @Email(message = "Email should be valid")
    @Size(min = 5, message = "Email is too short")
    private String email;

    @Pattern(regexp = "\\d{11}", message = "CPF must have 11 digits")
    private String cpf;

    @Pattern(regexp = "\\(\\d{2}\\) \\d{5}-\\d{4}", message = "Phone number must be in the format (XX) XXXXX-XXXX")
    private String phoneNumber;

    @Embedded
    private Address address;
}

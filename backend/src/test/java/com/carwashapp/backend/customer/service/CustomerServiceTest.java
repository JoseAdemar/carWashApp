package com.carwashapp.backend.customer.service;

import com.carwashapp.backend.customer.dto.AddressDTO;
import com.carwashapp.backend.customer.dto.CustomerDTO;
import com.carwashapp.backend.customer.exception.DuplicatedCPFException;
import com.carwashapp.backend.customer.interfaces.CustomerMapper;
import com.carwashapp.backend.customer.model.Address;
import com.carwashapp.backend.customer.model.Customer;
import com.carwashapp.backend.customer.repository.CustomerRepository;
import com.carwashapp.backend.customer.util.CustomerTestDataBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {
    @Mock
    private CustomerRepository customerRepository;

    @Mock
    private CustomerMapper customerMapper;

    @InjectMocks
    private CustomerService customerService;

    private AddressDTO addressDTO;
    private Address addressEntity;
    private CustomerDTO customerDTO;
    private Customer customerEntity;
    private Customer savedCustomerEntity;
    private CustomerDTO savedCustomerDTO;

    @BeforeEach
    void setUp() {
        addressDTO = CustomerTestDataBuilder.buildAddressDTO();
        addressEntity = CustomerTestDataBuilder.buildAddressEntity();
        customerDTO = CustomerTestDataBuilder.buildCustomerDTO(addressDTO);
        customerEntity = CustomerTestDataBuilder.buildCustomerEntity(addressEntity);
        savedCustomerEntity = CustomerTestDataBuilder.buildSavedCustomerEntity(1L, addressEntity);
        savedCustomerDTO = CustomerTestDataBuilder.buildSavedCustomerDTO(1L, addressDTO);
    }

    @Test
    @DisplayName("Should create customer successfully when valid customer dto is provided")
    void should_create_customer() {
        //Arrange
        when(customerMapper.toEntity(customerDTO)).thenReturn(customerEntity);
        when(customerRepository.existsByCpf(customerEntity.getCpf())).thenReturn(false);
        when(customerRepository.save(customerEntity)).thenReturn(savedCustomerEntity);
        when(customerMapper.toDTO(savedCustomerEntity)).thenReturn(savedCustomerDTO);

        //Act
        CustomerDTO result = customerService.create(customerDTO);

        //Assert
        assertNotNull(result);
        assertEquals("João Silva", result.name());
        assertEquals("São Paulo", result.address().city());

        //Verify
        verify(customerMapper).toEntity(customerDTO);
        verify(customerRepository).existsByCpf(customerEntity.getCpf());
        verify(customerRepository).save(customerEntity);
        verify(customerMapper).toDTO(savedCustomerEntity);
    }

    @Test
    @DisplayName("Should launch conflict exception case duplicated CPF exists")
    void shouldValidateDuplicatedCpf() {
        //Arrange
        String errorMessage = "CPF já cadastrado no sistema, tente outro CPF válido";
        when(customerMapper.toEntity(customerDTO)).thenReturn(customerEntity);
        when(customerRepository.existsByCpf(customerEntity.getCpf())).thenReturn(true);

        //Act & Assert
        DuplicatedCPFException exception = assertThrows(DuplicatedCPFException.class, () -> {
            customerService.create(customerDTO);
        });

        //Assert
        assertEquals(errorMessage, exception.getMessage());

        //Verify
        verify(customerMapper).toEntity(customerDTO);
        verify(customerRepository).existsByCpf(customerEntity.getCpf());
    }
}
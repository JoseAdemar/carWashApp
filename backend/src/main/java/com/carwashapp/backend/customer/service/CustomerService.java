package com.carwashapp.backend.customer.service;

import com.carwashapp.backend.customer.dto.CustomerDTO;
import com.carwashapp.backend.customer.exception.DuplicatedCPFException;
import com.carwashapp.backend.customer.interfaces.CustomerMapper;
import com.carwashapp.backend.customer.model.Customer;
import com.carwashapp.backend.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    private final CustomerMapper customerMapper;

    @Autowired
    public CustomerService(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    @Transactional
    public CustomerDTO create(CustomerDTO customerDTO) {
        var customer = customerMapper.toEntity(customerDTO);
        validateCpfUnique(customer);
        var savedCustomer = customerRepository.save(customer);
        return customerMapper.toDTO(savedCustomer);
    }

    private void validateCpfUnique(Customer customer) {
        boolean cpfExists = customerRepository.existsByCpf(customer.getCpf());
        if (cpfExists) {
            throw new DuplicatedCPFException("CPF já cadastrado no sistema, tente outro CPF válido");
        }
    }
}

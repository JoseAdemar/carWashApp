package com.carwashapp.backend.customer.interfaces;

import com.carwashapp.backend.customer.dto.CustomerDTO;
import com.carwashapp.backend.customer.model.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = AddressMapper.class)
public interface CustomerMapper {
    Customer toEntity(CustomerDTO dto);
    CustomerDTO toDTO(Customer entity);
}

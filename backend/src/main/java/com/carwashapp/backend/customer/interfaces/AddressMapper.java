package com.carwashapp.backend.customer.interfaces;

import com.carwashapp.backend.customer.dto.AddressDTO;
import com.carwashapp.backend.customer.model.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressMapper {
    Address toEntity(AddressDTO dto);
    AddressDTO toDTO(Address entity);
}

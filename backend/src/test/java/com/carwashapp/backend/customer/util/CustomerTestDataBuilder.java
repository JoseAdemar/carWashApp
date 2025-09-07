package com.carwashapp.backend.customer.util;

import com.carwashapp.backend.customer.dto.AddressDTO;
import com.carwashapp.backend.customer.dto.CustomerDTO;
import com.carwashapp.backend.customer.model.Address;
import com.carwashapp.backend.customer.model.Customer;

public class CustomerTestDataBuilder {

    public static AddressDTO buildAddressDTO() {
        return new AddressDTO("01234-567", "São Paulo", "Rua das Flores", "SP");
    }

    public static Address buildAddressEntity() {
        Address address = new Address();
        address.setZipCode("01234-567");
        address.setCity("São Paulo");
        address.setStreet("Rua das Flores");
        address.setState("SP");
        return address;
    }

    public static CustomerDTO buildCustomerDTO(AddressDTO addressDTO) {
        return new CustomerDTO(
                null,
                "João Silva",
                "joao.silva@email.com",
                "03581815139",
                "(61) 99882-6578",
                addressDTO
        );
    }

    public static Customer buildCustomerEntity(Address address) {
        return new Customer(
                null,
                "João Silva",
                "joao.silva@email.com",
                "03581815139",
                "(61) 99882-6578",
                address
        );
    }

    public static CustomerDTO buildSavedCustomerDTO(Long id, AddressDTO addressDTO) {
        return new CustomerDTO(
                id,
                "João Silva",
                "joao.silva@email.com",
                "03581815139",
                "(61) 99882-6578",
                addressDTO
        );
    }

    public static Customer buildSavedCustomerEntity(Long id, Address address) {
        return new Customer(
                id,
                "João Silva",
                "joao.silva@email.com",
                "03581815139",
                "(61) 99882-6578",
                address
        );
    }
}

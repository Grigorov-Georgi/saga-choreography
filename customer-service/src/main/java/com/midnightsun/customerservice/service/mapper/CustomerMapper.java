package com.midnightsun.customerservice.service.mapper;

import com.midnightsun.customerservice.model.Customer;
import com.midnightsun.customerservice.service.dto.CustomerDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerDTO toDTO(Customer customer);
    Customer toEntity(CustomerDTO customerDTO);
}

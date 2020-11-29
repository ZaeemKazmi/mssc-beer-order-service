package com.zk.msscbeerorderservice.web.mappers;

import com.zk.brewery.model.CustomerDto;
import com.zk.msscbeerorderservice.domain.Customer;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface CustomerMapper {
    CustomerDto customerToDto(Customer customer);

    Customer dtoToCustomer(Customer dto);
}
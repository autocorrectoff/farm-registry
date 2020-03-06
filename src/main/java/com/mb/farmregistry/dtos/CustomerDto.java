package com.mb.farmregistry.dtos;

import com.mb.farmregistry.models.Customer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {

    private Long id;

    private String name;

    public static Customer dtoToEntity(CustomerDto dto) {
        Customer customer = Customer.builder().name(dto.getName()).build();
        return customer;
    }
}

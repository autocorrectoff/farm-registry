package com.mb.farmregistry.services_impl;

import com.mb.farmregistry.dtos.CustomerDto;
import com.mb.farmregistry.models.Customer;
import com.mb.farmregistry.repositories.CustomerRepository;
import com.mb.farmregistry.services.ICustomerService;
import org.springframework.stereotype.Service;

import java.util.Map;

import static java.util.Map.entry;

@Service
public class CustomerService implements ICustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Map<String, Long> createCustomer(CustomerDto dto) {
        Customer customer = CustomerDto.dtoToEntity(dto);
        Customer created = customerRepository.save(customer);
        return Map.ofEntries(entry("customerId", created.getId()));
    }
}

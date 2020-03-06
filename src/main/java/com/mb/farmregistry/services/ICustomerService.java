package com.mb.farmregistry.services;

import com.mb.farmregistry.dtos.CustomerDto;

import java.util.Map;

public interface ICustomerService {

    Map<String, Long> createCustomer(CustomerDto dto);
}

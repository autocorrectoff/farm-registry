package com.mb.farmregistry.controllers;

import com.mb.farmregistry.dtos.CustomerDto;
import com.mb.farmregistry.services.ICustomerService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("customers")
public class CustomerController {

    private final ICustomerService customerService;

    public CustomerController(ICustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Long>> createCustomer(@RequestBody CustomerDto dto) {
        Map<String, Long> id = customerService.createCustomer(dto);
        return ResponseEntity.ok(id);
    }
}

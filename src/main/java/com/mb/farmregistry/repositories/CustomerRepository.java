package com.mb.farmregistry.repositories;

import com.mb.farmregistry.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}

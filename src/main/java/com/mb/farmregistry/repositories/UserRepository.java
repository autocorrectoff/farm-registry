package com.mb.farmregistry.repositories;

import com.mb.farmregistry.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

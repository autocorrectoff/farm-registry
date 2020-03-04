package com.mb.farmregistry.repositories;

import com.mb.farmregistry.models.Farm;
import com.mb.farmregistry.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FarmRepository extends JpaRepository<Farm, Long> {

    @Query("select f from Farm f join f.users u where u.id=:userId")
    List<Farm> findByUserId(@Param("userId") Long userId);
}

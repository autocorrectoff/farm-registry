package com.mb.farmregistry.repositories;

import com.mb.farmregistry.models.Farm;
import com.mb.farmregistry.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FarmRepository extends JpaRepository<Farm, Long> {

    @Query(value = "select f.id, f.name, f.customer_id from farm f join user_farm uf on f.id=uf.farm_id where uf.user_id=:userId", nativeQuery = true)
    List<Farm> findByUserId(@Param("userId") Long userId);
}

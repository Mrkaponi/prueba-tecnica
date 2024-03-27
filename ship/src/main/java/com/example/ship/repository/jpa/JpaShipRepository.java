package com.example.ship.repository.jpa;

import com.example.ship.repository.entities.Ship;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaShipRepository extends CrudRepository<Ship,Long> {
}

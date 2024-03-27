package com.example.ship.v1.service;


import com.example.ship.repository.entities.Ship;

import java.util.List;

public interface ShipService {
    public Object startShip(Long id );
    public boolean canAddCrewMember(Long id);
    public Object save(Ship ship);


    Ship findById(Long id);

    List<Ship> findAll();

    Ship update(Long id,Ship updatedShip);

    void delete(Long id);
}

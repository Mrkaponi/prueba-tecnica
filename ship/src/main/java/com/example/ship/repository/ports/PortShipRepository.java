package com.example.ship.repository.ports;


import com.example.ship.repository.entities.Ship;

public interface PortShipRepository extends BaseCrudPort<Ship,Long> {


    Ship update(Long id, Ship ship);

}

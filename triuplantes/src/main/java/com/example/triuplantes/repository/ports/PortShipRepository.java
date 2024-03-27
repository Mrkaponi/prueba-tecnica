package com.example.triuplantes.repository.ports;


import com.example.triuplantes.repository.entities.Ship;

public interface PortShipRepository extends BaseCrudPort<Ship,Long> {


    Ship update(Long id, Ship ship);

}

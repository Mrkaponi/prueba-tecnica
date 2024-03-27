package com.example.triuplantes.apis.ship;

import com.example.triuplantes.repository.entities.Ship;
import com.example.triuplantes.repository.repositories.ShipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ShipImp {

    @Autowired
    private ShipClient shipClient;

    public Ship findById(Long id){
        return shipClient.findById(id);
    }
    public List<Ship> findAllShips() {
        return shipClient.findAll();
    }

    public boolean canAddCrewMember(Long id) {
        return shipClient.canAddCrewMember(id);
    }
}

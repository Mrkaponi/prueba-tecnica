package com.example.ship.v1.ussecase;

import com.example.ship.repository.entities.Ship;
import com.example.ship.repository.ports.PortShipRepository;
import com.example.ship.v1.service.ShipService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ShipImp implements ShipService {

    private final PortShipRepository portShipRepository;

    public ShipImp(PortShipRepository portShipRepository) {
        this.portShipRepository = portShipRepository;
    }

    public boolean verifyCapacityShip(Long id) {
        return portShipRepository.findById(id)
                .map(ship -> !ship.getCrewMembers().isEmpty() && ship.getCrewMembers().size() <= 3)
                .orElse(false);
    }
    @Override
    public boolean canAddCrewMember(Long id) {
        return verifyCapacityShip(id);
    }
    @Override
    public Object startShip(Long id) {
        if (verifyCapacityShip(id)) {
            return "nave despegando";
        } else {
            return "no se peude despegar";
        }
    }
    @Override
    public Object save(Ship ship) {
        return portShipRepository.saveOrUpdate(ship);
    }

    @Override
    public Ship findById(Long id) {
        return portShipRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Ship> findAll() {
        return portShipRepository.findAll();
    }

    @Override
    public Ship update(Long id, Ship updatedShip) {

        return portShipRepository.update(id, updatedShip);
    }

    @Override
    public void delete(Long id) {

        portShipRepository.deleteById(id);
    }
}

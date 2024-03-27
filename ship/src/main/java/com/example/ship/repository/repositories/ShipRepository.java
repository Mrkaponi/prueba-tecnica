package com.example.ship.repository.repositories;

import com.example.ship.repository.entities.Ship;
import com.example.ship.repository.jpa.JpaShipRepository;
import com.example.ship.repository.ports.PortShipRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ShipRepository implements PortShipRepository {

    private final JpaShipRepository jpaBinValesRepository;

    public ShipRepository(JpaShipRepository jpaBinValesRepository) {
        this.jpaBinValesRepository = jpaBinValesRepository;
    }

    @Override
    public Ship saveOrUpdate(Ship object) {

        return jpaBinValesRepository.save(object);
    }

    @Override
    public List<Ship> findAll() {
        return (List<Ship>) jpaBinValesRepository.findAll();
    }

    @Override
    public Optional<Ship> findById(Long aLong) {
        return jpaBinValesRepository.findById(aLong);
    }


    @Override
    public void deleteById(Long aLong) {

        jpaBinValesRepository.deleteById(aLong);
    }

    @Override
    public Ship update(Long id, Ship updatedShip) {
        //se usar formas mas abstractas y patrones de diseño para el build update
        Optional<Ship> shipOptional = jpaBinValesRepository.findById(id);
        if (shipOptional.isPresent()) {
            shipOptional.orElseThrow().builderUpdate(updatedShip);
            return jpaBinValesRepository.save(shipOptional.orElseThrow());

        }
        return null;
    }
}


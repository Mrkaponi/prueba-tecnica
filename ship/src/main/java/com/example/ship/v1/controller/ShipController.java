package com.example.ship.v1.controller;

import com.example.ship.repository.entities.Ship;
import com.example.ship.v1.service.ShipService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/ships")
public class ShipController {


    private final ShipService shipService;

    public ShipController(ShipService shipService) {
        this.shipService = shipService;
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Ship ship) {
        return ResponseEntity.ok(shipService.save(ship));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ship> findById(@PathVariable Long id) {
        try {
            Ship ship = shipService.findById(id);
            return ResponseEntity.ok(ship);
        } catch (NoSuchElementException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/startShip/{id}")
    public ResponseEntity<?> verifyCapacityShip(@PathVariable Long  id) {
        return ResponseEntity.ok(shipService.startShip(id));
    }
    @GetMapping("/canAddCrewMember/{id}")
    public ResponseEntity<Boolean> canAddCrewMember(@PathVariable Long id) {
        boolean canAddCrewMember = shipService.canAddCrewMember(id);
        return ResponseEntity.ok(canAddCrewMember);
    }

    @GetMapping
    public ResponseEntity<List<Ship>> findAll() {
        return ResponseEntity.ok(shipService.findAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ship> update(@PathVariable Long id, @RequestBody Ship updatedShip) {
        Ship ship = shipService.update(id,updatedShip);
        if (ship != null) {
            return ResponseEntity.ok(ship);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        shipService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

package com.example.triuplantes.apis.ship;

import com.example.triuplantes.apis.dto.ShipDto;
import com.example.triuplantes.repository.entities.Ship;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient( url = "http://localhost:8080/ships/")
public interface ShipClient {

    @GetMapping("{id}")
    Ship findById(@PathVariable Long id); // Agregar método para buscar por ID

    @GetMapping // ruta del endpoint findAll en ShipController
    List<Ship> findAll();

    @GetMapping("canAddCrewMember/{id}")
    boolean canAddCrewMember(@PathVariable Long id);
}


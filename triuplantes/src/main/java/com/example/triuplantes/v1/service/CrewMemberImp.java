package com.example.triuplantes.v1.service;

import com.example.triuplantes.apis.ship.ShipImp;
import com.example.triuplantes.repository.entities.CrewMember;
import com.example.triuplantes.repository.entities.Ship;
import com.example.triuplantes.repository.ports.PortCrewMemberRepository;
import com.example.triuplantes.repository.repositories.ShipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CrewMemberImp {

    @Autowired
    private ShipImp shipClient;

    private PortCrewMemberRepository portCrewMemberRepository;


    public void save(Long id, CrewMember crewMember) {
        Ship ship = shipClient.findById(id);
        boolean canAddCrewMember = shipClient.canAddCrewMember(id);

        if (ship != null && canAddCrewMember) {
            crewMember.setShip(ship);
            portCrewMemberRepository.saveOrUpdate(crewMember);
        }
    }

    public List<CrewMember> findAllCrewMembers() {
        return portCrewMemberRepository.findAll(); // Obtener todos los miembros de la tripulación
    }

    public CrewMember findCrewMemberById(Long id) {
        return portCrewMemberRepository.findById(id).orElse(null); // Buscar un miembro de la tripulación por su ID
    }

    public void updateCrewMember(Long id, CrewMember updatedCrewMember) {
        CrewMember existingCrewMember = portCrewMemberRepository.findById(id).orElse(null); // Buscar el miembro de la tripulación existente
        if (existingCrewMember != null) {
            existingCrewMember.builderUpdate(updatedCrewMember); // Actualizar los campos del miembro de la tripulación existente
            portCrewMemberRepository.saveOrUpdate(existingCrewMember); // Guardar los cambios
        }
    }

    public void deleteCrewMember(Long id) {
        portCrewMemberRepository.deleteById(id); // Eliminar un miembro de la tripulación por su ID
    }
}

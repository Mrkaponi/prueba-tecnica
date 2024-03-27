package com.example.triuplantes.repository.repositories;

import com.example.triuplantes.repository.entities.CrewMember;
import com.example.triuplantes.repository.entities.Ship;
import com.example.triuplantes.repository.jpa.JpaCrewMember;
import com.example.triuplantes.repository.jpa.JpaShipRepository;
import com.example.triuplantes.repository.ports.PortCrewMemberRepository;
import com.example.triuplantes.repository.ports.PortShipRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CrewMemberRepository implements PortCrewMemberRepository {

    private final JpaCrewMember jpaCrewMember;

    public CrewMemberRepository(JpaCrewMember jpaBinValesRepository) {
        this.jpaCrewMember = jpaBinValesRepository;
    }

    @Override
    public CrewMember saveOrUpdate(CrewMember object) {

        return jpaCrewMember.save(object);
    }

    @Override
    public List<CrewMember> findAll() {
        return (List<CrewMember>) jpaCrewMember.findAll();
    }

    @Override
    public Optional<CrewMember> findById(Long aLong) {
        return jpaCrewMember.findById(aLong);
    }


    @Override
    public void deleteById(Long aLong) {

        jpaCrewMember.deleteById(aLong);
    }



    @Override
    public CrewMember update(Long id, CrewMember update) {
        Optional<CrewMember> crewMember = jpaCrewMember.findById(id);
        if (crewMember.isPresent()) {
            crewMember.orElseThrow().builderUpdate(update);
            return jpaCrewMember.save(crewMember.orElseThrow());

        }
        return null;    }
}


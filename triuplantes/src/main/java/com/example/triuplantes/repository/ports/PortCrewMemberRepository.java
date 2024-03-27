package com.example.triuplantes.repository.ports;


import com.example.triuplantes.repository.entities.CrewMember;
import com.example.triuplantes.repository.entities.Ship;

public interface PortCrewMemberRepository extends BaseCrudPort<CrewMember,Long> {


    CrewMember update(Long id, CrewMember ship);

}

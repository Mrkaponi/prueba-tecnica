package com.example.triuplantes.repository.jpa;

import com.example.triuplantes.repository.entities.CrewMember;
import com.example.triuplantes.repository.entities.Ship;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaCrewMember extends CrudRepository<CrewMember,Long> {

}

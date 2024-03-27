package com.example.triuplantes.v1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.triuplantes.repository.entities.CrewMember;
import com.example.triuplantes.v1.service.CrewMemberImp;

import java.util.List;

@RestController
@RequestMapping("/crew-members")
public class CrewMemberController {

    private final CrewMemberImp crewMemberService;

    @Autowired
    public CrewMemberController(CrewMemberImp crewMemberService) {
        this.crewMemberService = crewMemberService;
    }

    @PostMapping("/{shipId}")
    public ResponseEntity<Void> saveCrewMember(@PathVariable Long shipId, @RequestBody CrewMember crewMember) {
        crewMemberService.save(shipId, crewMember);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<CrewMember>> findAllCrewMembers() {
        List<CrewMember> crewMembers = crewMemberService.findAllCrewMembers();
        return ResponseEntity.ok(crewMembers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CrewMember> findCrewMemberById(@PathVariable Long id) {
        CrewMember crewMember = crewMemberService.findCrewMemberById(id);
        if (crewMember != null) {
            return ResponseEntity.ok(crewMember);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateCrewMember(@PathVariable Long id, @RequestBody CrewMember updatedCrewMember) {
        crewMemberService.updateCrewMember(id, updatedCrewMember);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCrewMember(@PathVariable Long id) {
        crewMemberService.deleteCrewMember(id);
        return ResponseEntity.noContent().build();
    }
}

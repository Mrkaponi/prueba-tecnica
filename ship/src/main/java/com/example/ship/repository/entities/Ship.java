package com.example.ship.repository.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter

public class Ship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @Getter

    private Long id;

    private boolean isCapacityFull;

    private String nameShip;

    @OneToMany(mappedBy = "ship", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CrewMember> crewMembers;



    public void builderUpdate(Ship updatedShip) {
        if (updatedShip.isCapacityFull != this.isCapacityFull) {
            this.isCapacityFull = updatedShip.isCapacityFull;
        }
        if (!updatedShip.nameShip.equals(this.nameShip)) {
            this.nameShip = updatedShip.nameShip;
        }

    }
}

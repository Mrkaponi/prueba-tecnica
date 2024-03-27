package com.example.ship.repository.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CrewMember   {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;



    @ManyToOne
    @JoinColumn(name = "ship_id") // Nombre de la columna en CrewMember que hace referencia a Ship
    @JsonIgnoreProperties
    private Ship ship;


}

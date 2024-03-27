package com.example.triuplantes.repository.entities;

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
    private Ship ship;
    public void builderUpdate(CrewMember update) {
        if (update.ship != null) {
            this.name = update.name;
        }

    }

}

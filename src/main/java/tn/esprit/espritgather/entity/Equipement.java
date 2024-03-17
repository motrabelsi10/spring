package tn.esprit.espritgather.entity;


import lombok.*;
import jakarta.persistence.*;
import tn.esprit.espritgather.enumeration.Equip;

import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Equipement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEquipmenet;
    @Enumerated(EnumType.STRING)
    private Equip equipement;

    @ManyToOne
    private Event event;
}
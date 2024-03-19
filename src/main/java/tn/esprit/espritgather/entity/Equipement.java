package tn.esprit.espritgather.entity;


import lombok.*;
import jakarta.persistence.*;
import tn.esprit.espritgather.enumeration.Equip;
import tn.esprit.espritgather.enumeration.TypeEquip;

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
    private Boolean approuvement;
    private String other;

    @Enumerated(EnumType.STRING)
    private TypeEquip typeequip;

    private float price;

    @ManyToOne
    private Event event;
}
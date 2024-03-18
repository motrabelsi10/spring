package tn.esprit.espritgather.entity;

import lombok.*;
import jakarta.persistence.*;

import tn.esprit.espritgather.enumeration.Bloc;
import tn.esprit.espritgather.enumeration.Classe;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Salle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSalle;
    @Enumerated(EnumType.STRING)
    private Bloc bloc;

    @Enumerated(EnumType.STRING)
    private Classe classe;

}
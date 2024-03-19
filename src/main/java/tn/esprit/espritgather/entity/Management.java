package tn.esprit.espritgather.entity;

import lombok.*;
import jakarta.persistence.*;
import tn.esprit.espritgather.enumeration.Bloc;
import tn.esprit.espritgather.enumeration.Classe;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Management {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idManagement;

    private Boolean approuvement;
    private Date heureStart;
    private Date heureFinish;

    @Enumerated(EnumType.STRING)
    private Bloc bloc;

    @Enumerated(EnumType.STRING)
    private Classe classe;



}

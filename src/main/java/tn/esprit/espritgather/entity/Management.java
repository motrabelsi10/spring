package tn.esprit.espritgather.entity;

import lombok.*;
import jakarta.persistence.*;
import tn.esprit.espritgather.enumeration.Bloc;

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

    private Date heureStart;
    private Date heureFinish;


    @OneToOne
    private Salle salle;


}

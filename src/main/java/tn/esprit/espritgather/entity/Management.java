package tn.esprit.espritgather.entity;

import lombok.*;
import jakarta.persistence.*;
import tn.esprit.espritgather.enumeration.Bloc;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Management {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idManagement;


    @Enumerated(EnumType.STRING)
    private Bloc bloc;
}

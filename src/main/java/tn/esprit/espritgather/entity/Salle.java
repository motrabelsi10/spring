package tn.esprit.espritgather.entity;

import lombok.*;
import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;
import tn.esprit.espritgather.enumeration.Bloc;
import tn.esprit.espritgather.enumeration.Role;

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
}
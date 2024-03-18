package tn.esprit.espritgather.entity;

import lombok.*;
import jakarta.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ProcessRecrutement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProcessRecrutement;

    private String note;
    private int niveau;
    private Boolean resultat;
}

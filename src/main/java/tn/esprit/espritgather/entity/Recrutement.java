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

public class Recrutement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRecrutement;

    private Date start;
    private Date finish;

    @ManyToOne
    private  User user;

}

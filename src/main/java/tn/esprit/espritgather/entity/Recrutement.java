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
    private String title;
    private String description;
    private Date dateStart;
    private Date dateFinish;

    private int niveau;

    @ManyToMany(mappedBy="recrutements", cascade = CascadeType.ALL)
    private Set<User> users;


    public void setRecrutement(Recrutement recrutement) {

    }
}

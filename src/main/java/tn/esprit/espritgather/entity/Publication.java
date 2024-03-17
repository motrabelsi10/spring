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

public class Publication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPublication;

    private String body;
    private Date datePublication;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="publication")
    private Set<Interaction> interactions;

    @ManyToOne
    private Event event;

    @ManyToOne
    private User user;
}

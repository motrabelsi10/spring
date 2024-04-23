package tn.esprit.espritgather.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    //@JsonIgnore
    @ManyToOne
    private Event event;
    //@JsonIgnore
    @ManyToOne
    private User user;
}
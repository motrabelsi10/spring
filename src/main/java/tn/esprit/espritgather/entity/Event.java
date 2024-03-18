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
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEvent;
    private String nom;
    private String informations;
    private Date dateStart;
    private Date dateFinish;
    private String place;

    @OneToOne(mappedBy="event")
    private Ticket ticket;

    @ManyToOne
    private User user;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="event")
    private Set<Feedback> feedbacks;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="event")
    private Set<Task> tasks;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="event")
    private Set<Equipement> equipements;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="event")
    private Set<Publication> publications;
}

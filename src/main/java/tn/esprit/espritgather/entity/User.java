package tn.esprit.espritgather.entity;
import tn.esprit.espritgather.enumeration.Role;

import lombok.*;
import jakarta.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;
    private String nom;
    private String prenom;
    private Date dateNaissance;
    private String adresse;
    private String mail;
    private String numTelephone;
    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="user")
    private Set<Event> events;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="user")
    private Set<Recrutement> recrutements;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="user")
    private Set<Feedback> feedbacks;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="user")
    private Set<Publication> publications;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="user")
    private Set<Interaction> interactions;


}


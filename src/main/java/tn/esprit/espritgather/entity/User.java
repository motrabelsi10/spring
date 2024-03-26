package tn.esprit.espritgather.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private String firstName;
    private String lastName;
    private Date birthDay;
    private String address;
    private String mail;
    private String telNumber;
    private String password;
    private Boolean approuvement;
    @Enumerated(EnumType.STRING)
    private Role role;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy="user")
    private Set<Event> events;


    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy="user")
    private Set<Ticket> tickets;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy="user")
    private Set<Feedback> feedbacks;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy="user")
    private Set<Publication> publications;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy="user")
    private Set<Interaction> interactions;
    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Volunteer> volunteers;
    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Recrutement> recrutements;




}


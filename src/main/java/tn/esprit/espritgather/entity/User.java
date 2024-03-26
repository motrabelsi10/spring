package tn.esprit.espritgather.entity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
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
    @NotEmpty(message = "FirstName cannot be empty")
    private String firstName;
    @NotEmpty(message = "LastName cannot be empty")
    private String lastName;
    private Date birthDay;
    private String address;
    @NotEmpty(message = "Email cannot be empty")
    @Email(message = "Invalid Email , Please enter a valid email")
    private String mail;
    @NotEmpty(message = "PhoneNumber cannot be empty")
    private String telNumber;
    @NotEmpty(message = "Password cannot be empty")

    private String password;
    private Boolean approuvement = false ;
    @Enumerated(EnumType.STRING)
    @NotEmpty(message = "Role cannot be empty")

    private Role role;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="user")
    private Set<Event> events;



    @OneToMany(cascade = CascadeType.ALL, mappedBy="user")
    private Set<Ticket> tickets;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="user")
    private Set<Feedback> feedbacks;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="user")
    private Set<Publication> publications;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="user")
    private Set<Interaction> interactions;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Volunteer> volunteers;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Recrutement> recrutements;




}


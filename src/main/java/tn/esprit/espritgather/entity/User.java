package tn.esprit.espritgather.entity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import tn.esprit.espritgather.enumeration.ClubTypes;
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
    @NotNull(message = "FirstName cannot be empty")
    private String firstName;
    @NotNull(message = "LastName cannot be empty")
    private String lastName;
    @NotNull(message = "Birthday cannot be empty")

    private Date birthDay;
    @NotNull(message = "address cannot be empty")

    private String address;
    @Email(message = "Invalid Email , Please enter a valid email")
    @NotBlank(message = "Email cannot be empty")

    private String mail;
    @NotNull(message = "PhoneNumber cannot be empty")
    private String telNumber;
    @NotEmpty(message = "Password cannot be empty")

    private String password;
    private Boolean approuvement = false ;
    @Enumerated(EnumType.STRING)
    @NotEmpty(message = "Role cannot be empty")

    private Role role;
    @NotNull(message = "ClubDetails cannot be empty")

    private String clubDetails ;
    @NotNull(message = "ClubName cannot be empty")

    private String clubName;

    @Enumerated(EnumType.STRING)

    private ClubTypes clubTypes;

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


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
public class Volunteer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVolunteer;

    private Boolean approuvement;

    @ManyToMany(mappedBy="volunteers", cascade = CascadeType.ALL)
    private Set<Task> tasks;

    @ManyToMany(mappedBy="volunteers", cascade = CascadeType.ALL)
    private Set<User> users;



}
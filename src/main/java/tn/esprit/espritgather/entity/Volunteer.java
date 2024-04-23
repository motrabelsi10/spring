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
public class Volunteer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVolunteer;

    private Boolean approuvement;

    @ManyToMany(mappedBy = "volunteers", cascade = CascadeType.ALL)
    //@JsonIgnore // Optional if you want to ignore this field during JSON serialization
    private Set<User> users;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Task> tasks;
}
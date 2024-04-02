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
    private String nameVolunteer;
    private Boolean approuvement;
    private String reason;
    private String availabilityVolunteer;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Task> chosenTask;

    @ManyToMany(mappedBy="volunteers", cascade = CascadeType.ALL)
    private Set<User> users;



}
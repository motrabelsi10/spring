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
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTask;
    private Boolean approuvement;
    private Date taskStart;
    private Date taskFinish;
    private String details;
    private int numberVolunteer;
    @ManyToOne
    private Event event;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Volunteer> volunteers;






}

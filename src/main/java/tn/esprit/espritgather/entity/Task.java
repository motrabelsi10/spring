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
    private Date start;
    private Date finish;
    private String details;

    @ManyToOne
    private Event event;

    @ManyToMany(mappedBy="tasks", cascade = CascadeType.ALL)
    private Set<User> users;


    @OneToMany(cascade = CascadeType.ALL, mappedBy="task")
    private Set<Volunteer> volunteers;


}

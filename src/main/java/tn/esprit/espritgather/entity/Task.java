package tn.esprit.espritgather.entity;

import lombok.*;
import jakarta.persistence.*;
import tn.esprit.espritgather.enumeration.EventSkill;

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
    private String nameTask;
    private Boolean approuvement;
    private Date taskStart;
    private Date taskFinish;
    private String details;
    private int numberVolunteer;


    @ManyToOne
    private Event event;

    @ElementCollection
    private Set<EventSkill> skills;



}

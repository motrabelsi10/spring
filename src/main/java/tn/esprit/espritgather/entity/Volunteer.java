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

    @ManyToOne
    private Task task;



}
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
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEvent;
    private String nameEvent;
    private String informations;
    private Date dateStart;
    private Date dateFinish;
    private String place;
    private int nbt;


    @ManyToOne
    private User user;


}

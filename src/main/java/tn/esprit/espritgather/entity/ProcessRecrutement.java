package tn.esprit.espritgather.entity;

import lombok.*;
import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ProcessRecrutement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProcessRecrutement;
    private String skills;
    private Date interviewDate;
    private String whyToJoin;
    private String availability;
    private boolean integratedInOtherClubs;
    private List<String> otherClubs;


    @ManyToOne
    @JoinColumn(name = "recrutement")
    private Recrutement recrutement;


}

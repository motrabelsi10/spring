package tn.esprit.espritgather.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Interaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idInteraction;

    private Boolean liked;
    private Boolean dislike;

    @JsonIgnore
    @ManyToOne
    private Publication publication;

    //@JsonIgnore
    @ManyToOne
    private User user;



}
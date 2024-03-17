package tn.esprit.espritgather.entity;

import lombok.*;
import jakarta.persistence.*;

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
    private String body;

    @ManyToOne
    private Publication publication;

    @ManyToOne
    private User user;



}

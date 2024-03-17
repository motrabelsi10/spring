package tn.esprit.espritgather.entity;

import lombok.*;
import jakarta.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFeedback;

    private String Title;
    private String body;
    private Boolean good;
    private Boolean bad;

    @ManyToOne
    private User user;

    @ManyToOne
    private Event event;

}

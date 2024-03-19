package tn.esprit.espritgather.entity;

import lombok.*;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFeedback;

    private String title;
    private String body;
    private Boolean note;
    private Date dateFeedback;

    @ManyToOne
    private User user;

    @ManyToOne
    private Event event;

}

package tn.esprit.espritgather.entity;

import lombok.*;
import jakarta.persistence.*;
import tn.esprit.espritgather.enumeration.AvailabilityVolunteer;
import tn.esprit.espritgather.enumeration.EventSkill;

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
    private String nameVolunteer;
    private Date firstDate;
    private Date lastDate;
    private Boolean approuvement;
    private String reason;
    @Enumerated(EnumType.STRING)
    private AvailabilityVolunteer availabilityVolunteer;


    @ManyToOne
    private Task task;

    @ManyToOne
    private User user;

    @ElementCollection
    private Set<EventSkill> skills;


    public boolean isApprouvement() {
        return approuvement;
    }
}


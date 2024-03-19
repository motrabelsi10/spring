package tn.esprit.espritgather.entity;

import lombok.*;
import jakarta.persistence.*;
import tn.esprit.espritgather.enumeration.TypeTicket;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTicket;
    private double price;
    private Date dateAchat;

    @Enumerated(EnumType.STRING)
    private TypeTicket typeticket;
    @ManyToOne
    private User user;
    @ManyToOne
    private Event event;

}

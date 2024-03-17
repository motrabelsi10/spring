package tn.esprit.espritgather.entity;

import lombok.*;
import jakarta.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTicket;


    @OneToOne
    private Event event;
    private double price;
}

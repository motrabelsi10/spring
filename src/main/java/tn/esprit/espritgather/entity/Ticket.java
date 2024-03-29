package tn.esprit.espritgather.entity;

import lombok.*;
import jakarta.persistence.*;
import tn.esprit.espritgather.enumeration.TypePay;
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
    private int nbts;

    private Date dateAchat;

    @Enumerated(EnumType.STRING)
    private TypePay typePay;


    @ManyToOne
    private User user;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "event")
    Event event;


}
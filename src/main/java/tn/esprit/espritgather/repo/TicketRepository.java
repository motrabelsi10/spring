package tn.esprit.espritgather.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.espritgather.entity.Ticket;

import java.util.List;

public interface TicketRepository  extends JpaRepository<Ticket,Long> {

    List<Ticket> findTicketsByEventIdEvent(Long eventId);


}

package tn.esprit.espritgather.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.espritgather.entity.Ticket;

public interface TicketRepository  extends JpaRepository<Ticket,Long> {
}

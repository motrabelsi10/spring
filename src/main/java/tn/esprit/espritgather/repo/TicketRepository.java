package tn.esprit.espritgather.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tn.esprit.espritgather.entity.Ticket;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface TicketRepository  extends JpaRepository<Ticket,Long> {

    List<Ticket> findTicketsByEventIdEvent(Long eventId);

    List<Ticket> findTicketsByEventIdEventAndUserIdUser(Long eventId,Long userId);




    @Query("SELECT t.dateAchat, SUM(t.nbts) FROM Ticket t GROUP BY t.dateAchat")
    List<Object[]> findTotalTicketsByDateAchat();

    @Query("SELECT t.typePay, SUM(t.nbts) FROM Ticket t GROUP BY t.typePay")
    List<Object[]> findTotalTicketsByTypeAchat();

    @Query("SELECT t.event.nameEvent, SUM(e.price * t.nbts) FROM Ticket t JOIN t.event e GROUP BY t.event.idEvent")
    List<Object[]> findTotalPricesByEvent();


}

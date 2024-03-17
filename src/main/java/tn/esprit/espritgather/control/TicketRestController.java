package tn.esprit.espritgather.control;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.espritgather.entity.Ticket;
import tn.esprit.espritgather.service.ITicketService;

import java.util.List;

@Tag(name = "Gestion Ticket")
@RestController
@AllArgsConstructor
@RequestMapping("/ticket")
public class TicketRestController {
    ITicketService ticketService;
    // http://localhost:8089/espritgather/ticket/retrieve-all-tickets
    @Operation(description = "récupérer toutes les tickets de la base de données")
    @GetMapping("/retrieve-all-tickets")
    public List<Ticket> getTickets() {
        List<Ticket> listTickets = ticketService.retrieveAllTickets();
        return listTickets;
    }
    // http://localhost:8089/espritgather/ticket/retrieve-ticket/8
    @GetMapping("/retrieve-ticket/{ticket-id}")
    public Ticket retrieveTicket(@PathVariable("ticket-id") Long chId) {
        Ticket ticket = ticketService.retrieveTicket(chId);
        return ticket;
    }
    // http://localhost:8089/espritgather/ticket/add-ticket
    @PostMapping("/add-ticket")
    public Ticket addTicket(@RequestBody Ticket c) {
        Ticket ticket = ticketService.addTicket(c);
        return ticket;
    }
    // http://localhost:8089/espritgather/ticket/remove-ticket/{ticket-id}
    @DeleteMapping("/remove-ticket/{ticket-id}")
    public void removeTicket(@PathVariable("ticket-id") Long chId) {
        ticketService.removeTicket(chId);
    }
    // http://localhost:8089/espritgather/ticket/modify-ticket
    @PutMapping("/modify-ticket")
    public Ticket modifyTicket(@RequestBody Ticket c) {
        Ticket ticket = ticketService.modifyTicket(c);
        return ticket;
    }

}
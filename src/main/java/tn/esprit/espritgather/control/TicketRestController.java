package tn.esprit.espritgather.control;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.espritgather.entity.Event;
import tn.esprit.espritgather.entity.Ticket;
import tn.esprit.espritgather.service.IEventService;
import tn.esprit.espritgather.service.ITicketService;

import java.util.List;

@Tag(name = "Gestion Ticket")
@RestController
@AllArgsConstructor
@RequestMapping("/ticket")
@CrossOrigin(origins = "*")

public class TicketRestController {
    ITicketService ticketService;
    IEventService eventService;
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

    @PostMapping("/add-ticket-by-event/{event-id}")
    public Ticket addTicketByEvent(@RequestBody Ticket ticket, @PathVariable("event-id") Long eventId) {
        Event event = eventService.retrieveEvent(eventId);


        ticket.setEvent(event);
        Ticket addedTicket = ticketService.addTicket(ticket);
        return addedTicket;
    }


    @DeleteMapping("/delete-ticket-by-event/{event-id}/{ticket-id}")
    public ResponseEntity<String> deleteTicketByEvent(@PathVariable("event-id") Long eventId, @PathVariable("ticket-id") Long ticketId) {
        Event event = eventService.retrieveEvent(eventId);
        if (event == null) {
            return ResponseEntity.notFound().build();
        }

        Ticket ticket = ticketService.retrieveTicket(ticketId);
        if (ticket == null || !ticket.getEvent().getIdEvent().equals(eventId)) {
            return ResponseEntity.notFound().build();
        }

        ticketService.removeTicket(ticketId);
        return ResponseEntity.ok("Ticket with ID " + ticketId + " deleted successfully.");
    }



    @GetMapping("/retrieve-tickets-by-event/{event-id}")
    public List<Ticket> retrieveTicketsByEvent(@PathVariable("event-id") Long eventId) {
        List<Ticket> tickets = ticketService.retrieveTicketsByEvent(eventId);
        return tickets;
    }

}
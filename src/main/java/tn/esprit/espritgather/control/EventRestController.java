package tn.esprit.espritgather.control;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.espritgather.entity.Event;
import tn.esprit.espritgather.entity.Ticket;
import tn.esprit.espritgather.repo.TicketRepository;
import tn.esprit.espritgather.service.IEventService;
import tn.esprit.espritgather.service.ITicketService;

import java.util.List;

@Tag(name = "Gestion Event")
@RestController
@AllArgsConstructor
@RequestMapping("/event")
@CrossOrigin(origins = "*")
public class EventRestController {
    IEventService eventService;
    ITicketService ticketService;
    TicketRepository ticketRepository;
    // http://localhost:8089/espritgather/event/retrieve-all-events
   @Operation(description = "récupérer toutes les event de la base de données")
    @GetMapping("/retrieve-all-events")
    public List<Event> getevents() {
        List<Event> listEvents = eventService.retrieveAllEvents();
        return listEvents;
    }
    // http://localhost:8089/espritgather/event/retrieve-event/8
    @GetMapping("/retrieve-event/{event-id}")
    public Event retrieveevent(@PathVariable("event-id") Long chId) {
        Event event = eventService.retrieveEvent(chId);
        return event;
    }
    // http://localhost:8089/espritgather/event/add-event
    @PostMapping("/add-event")
    public Event addevent(@RequestBody Event c) {
        Event event = eventService.addEvent(c);
        return event;
    }
    // http://localhost:8089/espritgather/event/remove-event/{event-id}

    //public void removeevent(@PathVariable("event-id") Long chId) {
        //eventService.removeEvent(chId);
    //}
@DeleteMapping("/remove-event/{event-id}")
    public void removeevent( @PathVariable("event-id")  Long eventId) {
        // Récupérer tous les tickets associés à l'événement
        List<Ticket> tickets = ticketRepository.findTicketsByEventIdEvent(eventId);

        // Supprimer chaque ticket individuellement
        for (Ticket ticket : tickets) {
            ticketRepository.delete(ticket);
        }

        // Enfin, supprimer l'événement
        eventService.removeEvent(eventId);
    }

    // http://localhost:8089/espritgather/event/modify-event
    @PutMapping("/modify-event")
    public Event modifyevent(@RequestBody Event c) {
        Event event = eventService.modifyEvent(c);
        return event;
    }
}
package tn.esprit.espritgather.control;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.espritgather.entity.Event;
import tn.esprit.espritgather.service.IEventService;

import java.util.List;

@Tag(name = "Gestion Event")
@RestController
@AllArgsConstructor
@RequestMapping("/event")
@CrossOrigin(origins = "http://localhost:4200")
public class EventRestController {
    IEventService eventService;
    // http://localhost:8089/espritgather/event/retrieve-all-events
   @Operation(description = "récupérer toutes les event de la base de données")
    @GetMapping("/events")
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
    @PostMapping("/events")
    public Event addevent(@RequestBody Event c) {
        Event event = eventService.addEvent(c);
        return event;
    }
    // http://localhost:8089/espritgather/event/remove-event/{event-id}
    @DeleteMapping("/remove-event/{event-id}")
    public void removeevent(@PathVariable("event-id") Long chId) {
        eventService.removeEvent(chId);
    }
    // http://localhost:8089/espritgather/event/modify-event
    @PutMapping("/modify-event")
    public Event modifyevent(@RequestBody Event c) {
        Event event = eventService.modifyEvent(c);
        return event;
    }
}
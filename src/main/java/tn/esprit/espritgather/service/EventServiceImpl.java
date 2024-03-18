package tn.esprit.espritgather.service;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.espritgather.entity.Event;
import tn.esprit.espritgather.repo.EventRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class EventServiceImpl implements IEventService {
    EventRepository eventRepository;
    public List<Event> retrieveAllEvents() { return eventRepository.findAll(); }
    public Event retrieveEvent(Long eventId) {
        return eventRepository.findById(eventId).get();
    }
    public Event addEvent(Event c) {
        return eventRepository.save(c);
    }
    public void removeEvent(Long eventId) {
        eventRepository.deleteById(eventId);
    }
    public Event modifyEvent(Event event) {
        return eventRepository.save(event);
    }
}
package tn.esprit.espritgather.service;

import org.springframework.web.multipart.MultipartFile;
import tn.esprit.espritgather.entity.Event;

import java.io.IOException;
import java.util.List;
public interface IEventService {
    public List<Event> retrieveAllEvents();

    public Event retrieveEvent(Long idEvent);

    public Event addEvent(Event c);

    public void removeEvent(Long idEvent);

    public Event modifyEvent(Event event);

    public List<Event> retrieveEventByNameEvent(String name);

    public List<Event> findAllEventsOrderedByPriceAsc();
    public List<Event> findAllEventsOrderedByNbt();

    public Event saveEvent(Event event, MultipartFile imageFile) throws IOException;



}




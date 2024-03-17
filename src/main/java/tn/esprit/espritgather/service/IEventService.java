package tn.esprit.espritgather.service;

import tn.esprit.espritgather.entity.Event;

import java.util.List;
public interface IEventService {
    public List<Event> retrieveAllEvents();
    public Event retrieveEvent(Long idEvent);
    public Event addEvent(Event c);
    public void removeEvent(Long idEvent);
    public Event modifyEvent(Event event);

}
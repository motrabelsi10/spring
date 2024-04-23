package tn.esprit.espritgather.service;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import tn.esprit.espritgather.entity.Event;
import tn.esprit.espritgather.entity.Ticket;
import tn.esprit.espritgather.repo.EventRepository;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

import static tn.esprit.espritgather.control.EventRestController.uploadDirectory;

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

    public Event saveEvent(Event event, MultipartFile imageFile) throws IOException {
        if (!imageFile.isEmpty()) {
            String fileName = saveImage(imageFile);
            event.setImagePath(fileName);
        }
        return eventRepository.save(event);
    }

    public List<Event> retrieveEventsByUser(Long userId) {
        return eventRepository.findEventsByUserIdUser(userId);
    }


    private String saveImage(MultipartFile imageFile) throws IOException {
        String fileName = UUID.randomUUID().toString() + "-" + imageFile.getOriginalFilename();
        String filePath = uploadDirectory + File.separator + fileName;
        byte[] bytes = imageFile.getBytes();
        Path path = Paths.get(filePath);
        Files.write(path, bytes);
        return fileName;
    }

    public List<Event> retrieveEventByNameEvent(String name){
        return eventRepository.findEventsByNameEvent(name);
    }

    public List<Event> findAllEventsOrderedByPriceAsc() {
        return eventRepository.findAllByOrderByPriceAsc();
    }

    public List<Event> findAllEventsOrderedByNbt() {
        return eventRepository.findAllEventsOrderedByNbt();
    }


}
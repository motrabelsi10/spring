package tn.esprit.espritgather.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.espritgather.entity.Ticket;
import tn.esprit.espritgather.repo.TicketRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class TicketServiceImpl implements ITicketService {
    TicketRepository ticketRepository;

    public List<Ticket> retrieveAllTickets() {
        return ticketRepository.findAll();
    }
    public Ticket retrieveTicket(Long ticketId) {
        return ticketRepository.findById(ticketId).get();
    }
    public Ticket addTicket(Ticket c) {
        return ticketRepository.save(c);
    }
    public void removeTicket(Long ticketId) {
        ticketRepository.deleteById(ticketId);
    }
    public Ticket modifyTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    public List<Ticket> retrieveTicketsByEvent(Long eventId) {
        return ticketRepository.findTicketsByEventIdEvent(eventId);
    }

    }

package tn.esprit.espritgather.service;

import tn.esprit.espritgather.entity.Ticket;

import java.util.List;
public interface ITicketService {
    public List<Ticket> retrieveAllTickets();
    public Ticket retrieveTicket(Long idTicket);
    public Ticket addTicket(Ticket c);
    public void removeTicket(Long idTicket);
    public Ticket modifyTicket(Ticket ticket);

}
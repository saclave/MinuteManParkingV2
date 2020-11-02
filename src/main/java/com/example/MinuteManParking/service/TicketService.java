package com.example.MinuteManParking.service;

import com.example.MinuteManParking.exceptions.TicketNotFound;
import com.example.MinuteManParking.model.Ticket;
import com.example.MinuteManParking.repository.TicketRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.MinuteManParking.exceptions.ExceptionConstants.*;

@Service
public class TicketService {
    private TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public List<Ticket> getAll() {
        return ticketRepository.findAll();
    }

    public Ticket retrieve(Integer ticketId) {
        return ticketRepository.findById(ticketId)
                .orElseThrow(() -> new TicketNotFound(TICKET_NOT_FOUND));
    }

    public Ticket create(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    public void delete(Integer ticketId) {
        retrieve(ticketId);
        ticketRepository.deleteById(ticketId);
    }

    public Ticket update(Integer ticketId, Ticket ticket) {
        Ticket retrievedTicket = retrieve(ticketId);
        retrievedTicket.setName(ticket.getName());
        retrievedTicket.setTimeIn(ticket.getTimeIn());
        retrievedTicket.setTimeOut(ticket.getTimeOut());
        retrievedTicket.setAmount(ticket.getAmount());
        return ticketRepository.save(retrievedTicket);
    }
}

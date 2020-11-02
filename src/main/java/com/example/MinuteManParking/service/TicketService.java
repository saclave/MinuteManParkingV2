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
        ticketRepository.deleteById(ticketId);
    }

    public Ticket update(Integer ticketId, Ticket ticket) {
        Ticket retrievedTicket = retrieve(ticketId);
        retrievedTicket.setCarId(ticket.getCarId());
        retrievedTicket.setSlotId(ticket.getSlotId());
        retrievedTicket.setTicketName(ticket.getTicketName());
        retrievedTicket.setTimeIn(ticket.getTimeIn());
        retrievedTicket.setTimeOut(ticket.getTimeOut());
        return ticketRepository.save(retrievedTicket);
    }
}

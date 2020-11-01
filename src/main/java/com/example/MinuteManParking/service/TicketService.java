package com.example.MinuteManParking.service;

import com.example.MinuteManParking.model.Ticket;
import com.example.MinuteManParking.repository.TicketRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {
    TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public List<Ticket> getAll() {
        return ticketRepository.findAll();
    }
}

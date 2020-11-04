package com.example.MinuteManParking.service;

import com.example.MinuteManParking.exceptions.TicketNotFound;
import com.example.MinuteManParking.model.ParkingLot;
import com.example.MinuteManParking.model.ParkingSlot;
import com.example.MinuteManParking.model.Ticket;
import com.example.MinuteManParking.repository.ParkingLotRepository;
import com.example.MinuteManParking.repository.ParkingSlotRepository;
import com.example.MinuteManParking.repository.TicketRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static com.example.MinuteManParking.exceptions.ExceptionConstants.TICKET_NOT_FOUND;

@Service
public class TicketService {
    private TicketRepository ticketRepository;
    private ParkingSlotRepository parkingSlotRepository;
    private ParkingLotRepository parkingLotRepository;

    public TicketService(TicketRepository ticketRepository, ParkingSlotRepository parkingSlotRepository,
                         ParkingLotRepository parkingLotRepository) {
        this.ticketRepository = ticketRepository;
        this.parkingSlotRepository = parkingSlotRepository;
        this.parkingLotRepository = parkingLotRepository;
    }

    public List<Ticket> getAll() {
        return ticketRepository.findAll();
    }

    public Ticket retrieve(Integer ticketId) {
        return ticketRepository.findById(ticketId)
                .orElseThrow(() -> new TicketNotFound(TICKET_NOT_FOUND));
    }

    public Ticket create(Ticket ticket) {
        ParkingSlot parkingSlot = parkingSlotRepository.findById(ticket.getParkingSlotId())
                .orElse(null);
        ParkingLot parkingLot = parkingLotRepository.findById(Objects.requireNonNull(parkingSlot).getParkingLotId())
                .orElse(null);

        ticket.setName(generateTicketString(Objects.requireNonNull(parkingLot).getName()) + "_"
                + parkingSlot.getId() + "-" + ticket.getId());

        return ticketRepository.save(ticket);
    }

    private String generateTicketString(String str) {
        return Arrays.stream(str.split(" "))
                .map(s -> s.substring(0, 1))
                .map(String::toUpperCase)
                .collect(Collectors.joining());
    }

    public void delete(Integer ticketId) {
        retrieve(ticketId);
        ticketRepository.deleteById(ticketId);
    }

    public Ticket update(Integer ticketId, Ticket ticket) {
        Ticket retrievedTicket = retrieve(ticketId);
        retrievedTicket.setTimeIn(ticket.getTimeIn());
        retrievedTicket.setTimeOut(ticket.getTimeOut());
        retrievedTicket.setAmount(ticket.getAmount());
        return ticketRepository.save(retrievedTicket);
    }
}

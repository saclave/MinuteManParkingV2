package com.example.MinuteManParking.controller;

import com.example.MinuteManParking.dto.TicketRequest;
import com.example.MinuteManParking.dto.TicketResponse;
import com.example.MinuteManParking.model.Ticket;
import com.example.MinuteManParking.service.TicketService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.MinuteManParking.mapper.TicketMapper.TICKET_MAPPER;

@RestController
@RequestMapping("/tickets")
public class TicketController {
    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping
    public List<TicketResponse> getAll() {
        List<Ticket> todoItems = ticketService.getAll();
        return todoItems.stream().map(TICKET_MAPPER::toResponse).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public TicketResponse getById(@PathVariable Integer id) {
        Ticket ticket = ticketService.retrieve(id);
        return TICKET_MAPPER.toResponse(ticket);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {
        ticketService.delete(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public TicketResponse updateById(@PathVariable Integer id, @RequestBody TicketRequest ticketRequest) {
        Ticket ticket = ticketService.update(id, TICKET_MAPPER.toEntity(ticketRequest));
        return TICKET_MAPPER.toResponse(ticket);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TicketResponse add(@RequestBody TicketRequest parkingSlotRequest) {
        Ticket ticket = ticketService.create(TICKET_MAPPER.toEntity(parkingSlotRequest));
        return TICKET_MAPPER.toResponse(ticket);
    }

}

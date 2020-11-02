package com.example.MinuteManParking.controller;

import com.example.MinuteManParking.dto.TicketRequest;
import com.example.MinuteManParking.dto.TicketResponse;
import com.example.MinuteManParking.mapper.TicketMapper;
import com.example.MinuteManParking.model.Ticket;
import com.example.MinuteManParking.service.TicketService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tickets")
public class TicketController {
    private final TicketService ticketService;
    private final TicketMapper ticketMapper;

    public TicketController(TicketService ticketService, TicketMapper ticketMapper) {
        this.ticketService = ticketService;
        this.ticketMapper = ticketMapper;
    }

    @GetMapping
    public List<TicketResponse> getAll() {
        List<Ticket> todoItems = ticketService.getAll();
        return todoItems.stream().map(ticketMapper::toResponse).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public TicketResponse getById(@PathVariable Integer id) {
        Ticket ticket = ticketService.retrieve(id);
        return ticketMapper.toResponse(ticket);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {
        ticketService.delete(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public TicketResponse updateById(@PathVariable Integer id, @RequestBody TicketRequest ticketRequest) {
        Ticket ticket = ticketService.update(id, ticketMapper.toEntity(ticketRequest));
        return ticketMapper.toResponse(ticket);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TicketResponse add(@RequestBody TicketRequest parkingSlotRequest) {
        Ticket ticket = ticketService.create(ticketMapper.toEntity(parkingSlotRequest));
        return ticketMapper.toResponse(ticket);
    }

}

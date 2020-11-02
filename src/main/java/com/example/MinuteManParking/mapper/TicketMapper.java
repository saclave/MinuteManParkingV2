package com.example.MinuteManParking.mapper;

import com.example.MinuteManParking.dto.TicketRequest;
import com.example.MinuteManParking.dto.TicketResponse;
import com.example.MinuteManParking.model.Ticket;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class TicketMapper {
    public TicketResponse toResponse(Ticket ticket){
        TicketResponse ticketResponse = new TicketResponse();
        BeanUtils.copyProperties(ticket, ticketResponse);
        return ticketResponse;
    }

    public Ticket toEntity(TicketRequest ticketRequest){
        Ticket ticket = new Ticket();
        BeanUtils.copyProperties(ticketRequest, ticket);
        return ticket;
    }
}

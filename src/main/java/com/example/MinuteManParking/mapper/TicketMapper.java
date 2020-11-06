package com.example.MinuteManParking.mapper;

import com.example.MinuteManParking.dto.TicketRequest;
import com.example.MinuteManParking.dto.TicketResponse;
import com.example.MinuteManParking.model.Ticket;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TicketMapper {
    TicketMapper TICKET_MAPPER = Mappers.getMapper(TicketMapper.class);

    @Mapping(target = "id", ignore = true)
    Ticket toEntity(TicketRequest ticketRequest);

    @Mapping(target = "parkingLotName", ignore = true)
    TicketResponse toResponse(Ticket ticket);
}

package com.example.MinuteManParking.service;

import com.example.MinuteManParking.model.Ticket;
import com.example.MinuteManParking.repository.TicketRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TicketServiceTest {
    private TicketRepository ticketRepository;
    private TicketService ticketService;

    @BeforeEach
    void setUp() {
        ticketRepository = mock(TicketRepository.class);
        ticketService = new TicketService(ticketRepository);
    }

    @Test
    void should_return_all_when_getAll() {
        //given
        List<Ticket> expected = asList(new Ticket(), new Ticket());
        //when
        when(ticketRepository.findAll()).thenReturn(expected);
        List<Ticket> actual = ticketService.getAll();
        //then
        assertEquals(expected, actual);
    }
}

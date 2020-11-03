package com.example.MinuteManParking.service;

import com.example.MinuteManParking.model.Ticket;
import com.example.MinuteManParking.repository.TicketRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.*;

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

    @Test
    void should_return_correct_ticket_when_get_by_id() {
        //given
        Ticket expected = new Ticket();
        //when
        when(ticketRepository.findById(expected.getId())).thenReturn(java.util.Optional.of(expected));
        Ticket actual = ticketService.retrieve(expected.getId());
        //then
        assertEquals(expected, actual);
    }

    @Test
    void should_return_ticket_when_create_given_user() {
        //given
        Ticket ticket = new Ticket();
        //when
        when(ticketRepository.save(ticket)).thenReturn(ticket);
        //then
        assertEquals(ticketService.create(ticket), ticket);
    }

    @Test
    void should_remove_ticket_when_delete_by_id() {
        //given
        Ticket ticket = new Ticket();
        //when
        when(ticketRepository.findById(ticket.getId())).thenReturn(Optional.of(ticket));
        ticketService.delete(ticket.getId());
        //then
        verify(ticketRepository, times(1)).deleteById(ticket.getId());
    }

    @Test
    void should_return_updated_parking_slot_when_update_given_update_details() {
        //given
        Ticket old = new Ticket();
        Ticket expected = new Ticket();
        old.setTimeOut("1");
        expected.setTimeOut("2");

        when(ticketRepository.findById(old.getId())).thenReturn(Optional.of(old));
        when(ticketRepository.save(old)).thenReturn(expected);
        //when
        Ticket updated = ticketService.update(old.getId(), old);
        //then
        assertSame(expected, updated);
    }

}

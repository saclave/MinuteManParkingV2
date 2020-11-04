package com.example.MinuteManParking.service;

import com.example.MinuteManParking.model.ParkingLot;
import com.example.MinuteManParking.model.ParkingSlot;
import com.example.MinuteManParking.model.Ticket;
import com.example.MinuteManParking.repository.ParkingLotRepository;
import com.example.MinuteManParking.repository.ParkingSlotRepository;
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
    private ParkingLotRepository parkingLotRepository;
    private ParkingSlotRepository parkingSlotRepository;
    private TicketService ticketService;

    @BeforeEach
    void setUp() {
        ticketRepository = mock(TicketRepository.class);
        parkingLotRepository = mock(ParkingLotRepository.class);
        parkingSlotRepository = mock(ParkingSlotRepository.class);
        ticketService = new TicketService(ticketRepository, parkingSlotRepository, parkingLotRepository);
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
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setId(123);
        parkingLot.setName("mall of asia");

        ParkingSlot parkingSlot = new ParkingSlot();
        parkingSlot.setId(123);
        parkingSlot.setParkingLotId(123);

        Ticket ticket = new Ticket();
        ticket.setId(69);
        ticket.setParkingSlotId(123);

        when(parkingSlotRepository.findById(anyInt())).thenReturn(Optional.of(parkingSlot));
        when(parkingLotRepository.findById(anyInt())).thenReturn(Optional.of(parkingLot));
        //when
        when(ticketRepository.save(ticket)).thenReturn(ticket);
        Ticket actual = ticketService.create(ticket);
        //then
        assertEquals(actual, ticket);
        assertEquals(actual.getName(), "MOA_123-69");
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

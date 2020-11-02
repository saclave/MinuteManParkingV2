package com.example.MinuteManParking.service;

import com.example.MinuteManParking.model.ParkingSlot;
import com.example.MinuteManParking.model.User;
import com.example.MinuteManParking.repository.ParkingSlotRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class ParkingSlotServiceTest {
    private ParkingSlotRepository parkingSlotRepository;
    private ParkingSlotService parkingSlotService;

    @BeforeEach
    void setUp() {
        parkingSlotRepository = mock(ParkingSlotRepository.class);
        parkingSlotService = new ParkingSlotService(parkingSlotRepository);
    }

    @Test
    void should_return_all_when_getAll() {
        //given
        List<ParkingSlot> expected = asList(new ParkingSlot(), new ParkingSlot());
        //when
        when(parkingSlotRepository.findAll()).thenReturn(expected);
        List<ParkingSlot> actual = parkingSlotService.getAll();
        //then
        assertEquals(expected, actual);
    }

    @Test
    void should_return_correct_user_when_get_by_id() {
        //given
        ParkingSlot expected = new ParkingSlot();
        //when
        when(parkingSlotRepository.findById(expected.getId())).thenReturn(java.util.Optional.of(expected));
        ParkingSlot actual = parkingSlotService.retrieve(expected.getId());
        //then
        assertEquals(expected, actual);
    }

    @Test
    void should_return_parking_slot_when_create_given_user() {
        //given
        ParkingSlot parkingSlot = new ParkingSlot();
        //when
        when(parkingSlotRepository.save(parkingSlot)).thenReturn(parkingSlot);
        //then
        assertEquals(parkingSlotService.create(parkingSlot), parkingSlot);
    }

    @Test
    void should_remove_parking_slot_when_delete_by_id() {
        //given
        ParkingSlot parkingSlot = new ParkingSlot();
        //when
        when(parkingSlotRepository.findById(parkingSlot.getId())).thenReturn(Optional.of(parkingSlot));
        parkingSlotService.delete(parkingSlot.getId());
        //then
        verify(parkingSlotRepository, times(1)).deleteById(parkingSlot.getId());
    }

    @Test
    void should_return_updated_parking_slot_when_update_given_update_details() {
        //given
        ParkingSlot old = new ParkingSlot();
        ParkingSlot expected = new ParkingSlot();
        old.setAvailability(true);
        expected.setAvailability(false);

        when(parkingSlotRepository.findById(old.getId())).thenReturn(Optional.of(old));
        when(parkingSlotRepository.save(old)).thenReturn(expected);
        //when
        ParkingSlot updated = parkingSlotService.update(old.getId(), old);
        //then
        assertSame(expected, updated);
    }

}

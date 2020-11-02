package com.example.MinuteManParking.service;

import com.example.MinuteManParking.model.ParkingLot;
import com.example.MinuteManParking.repository.ParkingLotRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class ParkingLotServiceTest {
    private ParkingLotRepository parkingLotRepository;
    private ParkingLotService parkingLotService;

    @BeforeEach
    void setUp() {
        parkingLotRepository = mock(ParkingLotRepository.class);
        parkingLotService = new ParkingLotService(parkingLotRepository);
    }

    @Test
    void should_return_all_when_getAll() {
        //given
        List<ParkingLot> expected = asList(new ParkingLot(), new ParkingLot());
        //when
        when(parkingLotRepository.findAll()).thenReturn(expected);
        List<ParkingLot> actual = parkingLotService.getAll();
        //then
        assertEquals(expected, actual);
    }

    @Test
    void should_return_correct_parking_lot_when_get_by_id() {
        //given
        ParkingLot expected = new ParkingLot();
        //when
        when(parkingLotRepository.findById(expected.getParkingLotId())).thenReturn(java.util.Optional.of(expected));
        ParkingLot actual = parkingLotService.retrieve(expected.getParkingLotId());
        //then
        assertEquals(expected, actual);
    }

    @Test
    void should_return_parking_lot_when_create_given_user() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        //when
        when(parkingLotRepository.save(parkingLot)).thenReturn(parkingLot);
        //then
        assertEquals(parkingLotService.create(parkingLot), parkingLot);
    }

    @Test
    void should_remove_parking_lot_when_delete_by_id() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        //when
        parkingLotService.delete(parkingLot.getParkingLotId());
        //then
        verify(parkingLotRepository, times(1)).deleteById(parkingLot.getParkingLotId());
    }

    @Test
    void should_return_updated_task_when_update_given_update_details() {
        //given
        ParkingLot old = new ParkingLot(1.0, 1.0, "old", 1.0);
        ParkingLot expected = new ParkingLot(2.0, 2.0, "expected", 2.0);

        when(parkingLotRepository.findById(old.getParkingLotId())).thenReturn(Optional.of(old));
        when(parkingLotRepository.save(old)).thenReturn(expected);
        //when
        ParkingLot updated = parkingLotService.update(old.getParkingLotId(), old);
        //then
        assertSame(expected, updated);
    }
}

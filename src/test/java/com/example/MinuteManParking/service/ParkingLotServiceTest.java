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
        when(parkingLotRepository.findById(expected.getId())).thenReturn(java.util.Optional.of(expected));
        ParkingLot actual = parkingLotService.retrieve(expected.getId());
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
        when(parkingLotRepository.findById(parkingLot.getId())).thenReturn(Optional.of(parkingLot));
        parkingLotService.delete(parkingLot.getId());
        //then
        verify(parkingLotRepository, times(1)).deleteById(parkingLot.getId());
    }

    @Test
    void should_return_updated_task_when_update_given_update_details() {
        //given
        ParkingLot old = new ParkingLot();
        ParkingLot expected = new ParkingLot();
        old.setPrice(1.0);
        expected.setPrice(2.0);

        when(parkingLotRepository.findById(old.getId())).thenReturn(Optional.of(old));
        when(parkingLotRepository.save(old)).thenReturn(expected);
        //when
        ParkingLot updated = parkingLotService.update(old.getId(), old);
        //then
        assertSame(expected, updated);
    }

    @Test
    void should_return_list_by_name(){
        when(parkingLotRepository.findByCity("Pasay")).thenReturn(asList(new ParkingLot(), new ParkingLot()));
        List<ParkingLot> parkingLots = parkingLotService.getParkingLotsByCity("Pasay");
        assertEquals(2, parkingLots.size());
    }
}

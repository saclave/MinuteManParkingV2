package com.example.MinuteManParking.service;

import com.example.MinuteManParking.model.Hazard;
import com.example.MinuteManParking.repository.HazardRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.*;

class HazardServiceTest {
    private HazardRepository hazardRepository;
    private HazardService hazardService;

    @BeforeEach
    void setup() {
        hazardRepository = mock(HazardRepository.class);
        hazardService = new HazardService(hazardRepository);
    }

    @Test
    void should_return_all_when_getAll() {
        //given
        List<Hazard> expected = asList(new Hazard(), new Hazard());
        //when
        when(hazardRepository.findAll()).thenReturn(expected);
        List<Hazard> actual = hazardService.getAll();
        //then
        assertEquals(expected, actual);
    }

    @Test
    void should_return_correct_parking_lot_when_get_by_id() {
        //given
        Hazard expected = new Hazard();
        //when
        when(hazardRepository.findById(expected.getId())).thenReturn(java.util.Optional.of(expected));
        Hazard actual = hazardService.retrieve(expected.getId());
        //then
        assertEquals(expected, actual);
    }

    @Test
    void should_return_parking_lot_when_create_given_user() {
        //given
        Hazard hazard = new Hazard();
        //when
        hazard.setType("ABC");
        when(hazardRepository.save(hazard)).thenReturn(hazard);
        //then
        assertEquals(hazardService.create(hazard), hazard);
    }


    @Test
    void should_remove_parking_lot_when_delete_by_id() {
        //given
        Hazard hazard = new Hazard();
        //when
        when(hazardRepository.findById(hazard.getId())).thenReturn(Optional.of(hazard));
        hazardService.delete(hazard.getId());
        //then
        verify(hazardRepository, times(1)).deleteById(hazard.getId());
    }

    @Test
    void should_return_updated_task_when_update_given_update_details() {
        //given
        Hazard old = new Hazard();
        Hazard expected = new Hazard();
        old.setLongitude(1.0);
        expected.setLongitude(2.0);
        expected.setType("ABC");
        old.setType("ABC");

        when(hazardRepository.findById(old.getId())).thenReturn(Optional.of(old));
        when(hazardRepository.save(old)).thenReturn(expected);
        //when
        Hazard updated = hazardService.update(old.getId(), old);
        //then
        assertSame(expected, updated);
    }
}

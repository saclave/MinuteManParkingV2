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
    void should_remove_parking_lot_when_delete_by_id() {
        //given
        Hazard hazard = new Hazard();
        //when
        when(hazardRepository.findById(hazard.getId())).thenReturn(Optional.of(hazard));
        hazardService.delete(hazard.getId());
        //then
        verify(hazardRepository, times(1)).deleteById(hazard.getId());
    }

}

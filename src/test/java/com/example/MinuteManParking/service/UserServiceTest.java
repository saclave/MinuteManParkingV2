package com.example.MinuteManParking.service;

import com.example.MinuteManParking.exceptions.ParkingLotNotFound;
import com.example.MinuteManParking.exceptions.ParkingSlotNotFound;
import com.example.MinuteManParking.model.ParkingLot;
import com.example.MinuteManParking.model.ParkingSlot;
import com.example.MinuteManParking.model.User;
import com.example.MinuteManParking.repository.ParkingLotRepository;
import com.example.MinuteManParking.repository.ParkingSlotRepository;
import com.example.MinuteManParking.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.List;
import java.util.Optional;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceTest {
    private UserRepository userRepository;
    private UserService userService;
    private ParkingSlotRepository parkingSlotRepository;
    private ParkingLotRepository parkingLotRepository;

    private final int NONE = 0;
    private final int ONCE = 1;

    @BeforeEach
    void setUp() {
        userRepository = mock(UserRepository.class);
        parkingSlotRepository = mock(ParkingSlotRepository.class);
        parkingLotRepository = mock(ParkingLotRepository.class);

        userService = new UserService(userRepository,
                parkingSlotRepository,
                parkingLotRepository);
    }

    @Test
    void should_return_all_when_getAll() {
        //given
        List<User> expected = asList(new User(), new User());
        //when
        when(userRepository.findAll()).thenReturn(expected);
        List<User> actual = userService.getAll();
        //then
        assertEquals(expected, actual);
    }

    @Test
    void should_return_correct_user_when_get_by_id() {
        //given
        User expected = new User();
        //when
        when(userRepository.findById(expected.getId())).thenReturn(java.util.Optional.of(expected));
        User actual = userService.retrieve(expected.getId());
        //then
        assertEquals(expected, actual);
    }

    @Test
    void should_return_user_when_create_given_user() {
        //given
        User user = new User();
        //when
        when(userRepository.save(user)).thenReturn(user);
        //then
        assertEquals(userService.create(user), user);
    }

    @Test
    void should_remove_todo_when_delete_by_id() {
        //given
        User user = new User();
        //when
        when(userRepository.findById(user.getId())).thenReturn(java.util.Optional.of(user));
        userService.delete(user.getId());
        //then
        verify(userRepository, times(1)).deleteById(user.getId());
    }

    @Test
    void should_return_updated_task_when_update_given_update_details() {
        //given
        User old = new User();
        User expected = new User();
        old.setUsername("1");
        expected.setUsername("2");

        when(userRepository.findById(old.getId())).thenReturn(Optional.of(old));
        when(userRepository.save(old)).thenReturn(expected);
        //when
        User updated = userService.update(old.getId(), old);
        //then
        assertSame(expected, updated);
    }

    @Test
    void should_return_parking_lot_name_when_get_parking_lot_name_given_parking_slot_id() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setId(1);
        parkingLot.setName("Parking Lot");

        ParkingSlot parkingSlot = new ParkingSlot();
        parkingSlot.setId(1);
        parkingSlot.setParkingLotId(parkingLot.getId());

        when(parkingSlotRepository.findById(parkingSlot.getId())).thenReturn(Optional.of(parkingSlot));
        when(parkingLotRepository.findById(parkingLot.getId())).thenReturn(Optional.of(parkingLot));

        //when
        String parkingLotName = userService.getParkingLotName(parkingSlot.getParkingLotId());

        //then
        verify(parkingSlotRepository, times(ONCE)).findById(parkingSlot.getId());
        verify(parkingLotRepository, times(ONCE)).findById(parkingLot.getId());
        assertSame(parkingLot.getName(), parkingLotName);
    }

    @Test
    void should_throw_parking_lot_not_found_when_get_parking_lot_name_given_parking_slot_id_with_missing_parking_lot() {
        //given
        ParkingSlot parkingSlot = new ParkingSlot();
        parkingSlot.setId(1);
        parkingSlot.setParkingLotId(1);

        when(parkingSlotRepository.findById(parkingSlot.getId())).thenReturn(Optional.of(parkingSlot));
        when(parkingLotRepository.findById(parkingSlot.getParkingLotId())).thenReturn(Optional.empty());

        //when
        Executable executable = () -> userService.getParkingLotName(parkingSlot.getParkingLotId());

        //then
        assertThrows(ParkingLotNotFound.class, executable);
        verify(parkingSlotRepository, times(ONCE)).findById(parkingSlot.getId());
        verify(parkingLotRepository, times(ONCE)).findById(parkingSlot.getParkingLotId());
    }

    @Test
    void should_throw_parking_slot_not_found_when_get_parking_lot_name_given_missing_parking_slot_id() {
        //given
        Integer parkingSlotId = 1;

        when(parkingSlotRepository.findById(parkingSlotId)).thenReturn(Optional.empty());

        //when
        Executable executable = () -> userService.getParkingLotName(parkingSlotId);

        //then
        assertThrows(ParkingSlotNotFound.class, executable);
        verify(parkingSlotRepository, times(ONCE)).findById(parkingSlotId);
        verify(parkingLotRepository, times(NONE)).findById(any(Integer.class));
    }
}

package com.example.MinuteManParking.service;

import com.example.MinuteManParking.model.User;
import com.example.MinuteManParking.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.*;

class UserServiceTest {
    private UserRepository userRepository;
    private UserService userService;

    @BeforeEach
    void setUp() {
        userRepository = mock(UserRepository.class);
        userService = new UserService(userRepository);
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

}

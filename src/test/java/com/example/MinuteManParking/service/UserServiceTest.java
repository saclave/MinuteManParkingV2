package com.example.MinuteManParking.service;

import com.example.MinuteManParking.model.User;
import com.example.MinuteManParking.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class UserServiceTest {
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
        assertEquals(userService.create(user),user);
    }

    @Test
    void should_remove_todo_when_delete_by_id() {
        //given
        User user = new User();
        //when
        userService.delete(user.getId());
        //then
        verify(userRepository, times(1)).deleteById(user.getId());
    }
}

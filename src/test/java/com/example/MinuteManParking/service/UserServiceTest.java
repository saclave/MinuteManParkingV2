package com.example.MinuteManParking.service;

import com.example.MinuteManParking.model.User;
import com.example.MinuteManParking.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserServiceTest {
    private UserRepository userRepository;
    private UserService userService;

    @BeforeEach
    void setUp() {
        userRepository = mock(UserRepository.class);
        userService = new UserService(userRepository);
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
}

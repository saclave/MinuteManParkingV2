package com.example.MinuteManParking.service;

import com.example.MinuteManParking.model.User;
import com.example.MinuteManParking.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User create(User user) {
        return userRepository.save(user);
    }
}

package com.example.MinuteManParking.mapper;

import com.example.MinuteManParking.dto.UserRequest;
import com.example.MinuteManParking.dto.UserResponse;
import com.example.MinuteManParking.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserResponse toResponse(User user) {
        UserResponse userResponse = new UserResponse();
        BeanUtils.copyProperties(user, userResponse);
        return userResponse;
    }

    public User toEntity(UserRequest userRequest) {
        User user = new User();
        BeanUtils.copyProperties(userRequest, user);
        return user;
    }
}

package com.example.MinuteManParking.controller;
import com.example.MinuteManParking.dto.UserRequest;
import com.example.MinuteManParking.dto.UserResponse;
import com.example.MinuteManParking.mapper.UserMapper;
import com.example.MinuteManParking.model.User;
import com.example.MinuteManParking.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;

    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse addTodoItem(@RequestBody UserRequest userRequest) {
        User user = userService.create(userMapper.toEntity(userRequest));
        return userMapper.toResponse(user);
    }
}

package com.example.MinuteManParking.controller;
import com.example.MinuteManParking.dto.UserRequest;
import com.example.MinuteManParking.dto.UserResponse;
import com.example.MinuteManParking.mapper.UserMapper;
import com.example.MinuteManParking.model.User;
import com.example.MinuteManParking.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;

    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping
    public List<UserResponse> getAll() {
        List<User> todoItems = userService.getAll();
        return todoItems.stream().map(userMapper::toResponse).collect(Collectors.toList());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse add(@RequestBody UserRequest userRequest) {
        User user = userService.create(userMapper.toEntity(userRequest));
        return userMapper.toResponse(user);
    }

    @GetMapping("/{id}")
    public UserResponse getById(@PathVariable Integer id) {
        User user = userService.retrieve(id);
        return userMapper.toResponse(user);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {
        userService.delete(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse updateById(@PathVariable Integer id, @RequestBody UserRequest userRequest) {
        User user = userService.update(id, userMapper.toEntity(userRequest));
        return userMapper.toResponse(user);
    }
}

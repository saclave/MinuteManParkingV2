package com.example.MinuteManParking.controller;

import com.example.MinuteManParking.dto.UserRequest;
import com.example.MinuteManParking.dto.UserResponse;
import com.example.MinuteManParking.model.Car;
import com.example.MinuteManParking.model.Ticket;
import com.example.MinuteManParking.model.User;
import com.example.MinuteManParking.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.MinuteManParking.mapper.UserMapper.USER_MAPPER;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserResponse> getAll() {
        List<User> todoItems = userService.getAll();
        return todoItems.stream().map(USER_MAPPER::toResponse).collect(Collectors.toList());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse add(@RequestBody UserRequest userRequest) {
        User user = userService.create(USER_MAPPER.toEntity(userRequest));
        return USER_MAPPER.toResponse(user);
    }

    @GetMapping("/{id}")
    public UserResponse getById(@PathVariable Integer id) {
        User user = userService.retrieve(id);
        return USER_MAPPER.toResponse(user);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {
        userService.delete(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse updateById(@PathVariable Integer id, @RequestBody UserRequest userRequest) {
        User user = userService.update(id, USER_MAPPER.toEntity(userRequest));
        return USER_MAPPER.toResponse(user);
    }

    @GetMapping(params = {"username", "password"})
    public UserResponse getByUsernamePassword(@RequestParam("username") String username, @RequestParam("password") String password) {
        User user = userService.findByUsernameAndPassword(username, password);
        return USER_MAPPER.toResponse(user);
    }

    @GetMapping("/{id}/carList")
    public List<Car> getCarList(@PathVariable Integer id) {
        return userService.getCarsByUserId(id);
    }

    @GetMapping("/{id}/ticketList")
    public List<Ticket> getTicketList(@PathVariable Integer id) {
        return userService.getTicketsByUserId(id);
    }
}

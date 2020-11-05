package com.example.MinuteManParking.controller;

import com.example.MinuteManParking.dto.TicketResponse;
import com.example.MinuteManParking.dto.UserRequest;
import com.example.MinuteManParking.dto.UserResponse;
import com.example.MinuteManParking.model.Car;
import com.example.MinuteManParking.model.User;
import com.example.MinuteManParking.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.MinuteManParking.mapper.TicketMapper.TICKET_MAPPER;
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

    @GetMapping("{/img_src/{id}")
    public String getUserImgSrc(@PathVariable Integer id) {
        return userService.getImgSrc(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse add(@RequestBody UserRequest userRequest) {
        User user = userService.create(USER_MAPPER.toEntity(userRequest));
        user.setImgSrc("https://secureservercdn.net/160.153.138.163/752.d1a.myftpupload.com/wp-content/uploads/2017/02/blank-profile-picture-973460_1280.png");
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
    public List<TicketResponse> getTicketList(@PathVariable Integer id) {
        return userService.getTicketsByUserId(id).stream()
                .map(ticket -> {
                    String parkingLotName = userService.getParkingLotName(ticket.getParkingSlotId());

                    TicketResponse ticketResponse = TICKET_MAPPER.toResponse(ticket);
                    ticketResponse.setParkingLotName(parkingLotName);

                    return ticketResponse;
                }).collect(Collectors.toList());
    }
}

package com.example.MinuteManParking.controller;
import com.example.MinuteManParking.dto.UserMapper;
import com.example.MinuteManParking.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
//    private final UserService userService;
//    private final UserMapper userMapper;
//
//    public UserController() {
//    }
//
////    @GetMapping("/{id}")
////    public UserResponse getById(@PathVariable Integer id) {
////        User user = userService.retrieve(id);
////        return userMapper.toResponse(user);
////    }
}

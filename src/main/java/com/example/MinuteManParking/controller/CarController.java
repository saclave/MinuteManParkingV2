package com.example.MinuteManParking.controller;

import com.example.MinuteManParking.mapper.CarMapper;
import com.example.MinuteManParking.service.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {
    private final CarService carService;
    private final CarMapper carMapper;

    public CarController(CarService carService, CarMapper carMapper) {
        this.carService = carService;
        this.carMapper = carMapper;
    }

    @GetMapping
    public List<Car> getAll(){ return todoListService.getAllTodos(); }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TodoListResponse addTodo(@RequestBody TodoListRequest todoListRequest){
        TodoItem todoItem = todoListMapper.toEntity(todoListRequest);
        return todoListMapper.toResponse(todoListService.create(todoItem));
    }
}

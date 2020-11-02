package com.example.MinuteManParking.controller;

import com.example.MinuteManParking.dto.CarRequest;
import com.example.MinuteManParking.dto.CarResponse;
import com.example.MinuteManParking.mapper.CarMapper;
import com.example.MinuteManParking.model.Car;
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
    public List<Car> getAll(){ return carService.getAllCars(); }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CarResponse addCar(@RequestBody CarRequest carRequest){
        Car car = carMapper.toEntity(carRequest);
        return carMapper.toResponse(carService.create(car));
    }

    @GetMapping("/{car_id}")
    public CarResponse getCar(@PathVariable("car_id") Integer id) {
        return carMapper.toResponse(carService.getCar(id));
    }

    @PutMapping("/{car_id}")
    public CarResponse updateTodoStatus(@PathVariable("car_id") Integer id, @RequestBody CarRequest carRequest) {
        Car car = carMapper.toEntity(carRequest);
        Car updatedCar = carService.updateCarDetails(id, car);
        return carMapper.toResponse(updatedCar);
    }

    @DeleteMapping("/{car_id}")
    public void deleteCar(@PathVariable Integer id) {
        carService.deleteCar(id);
    }

}

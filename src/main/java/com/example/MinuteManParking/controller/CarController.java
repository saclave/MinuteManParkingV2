package com.example.MinuteManParking.controller;

import com.example.MinuteManParking.dto.CarRequest;
import com.example.MinuteManParking.dto.CarResponse;
import com.example.MinuteManParking.mapper.CarMapper;
import com.example.MinuteManParking.model.Car;
import com.example.MinuteManParking.service.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.MinuteManParking.mapper.CarMapper.CAR_MAPPER;

@RestController
@RequestMapping("/cars")
public class CarController {
    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public List<Car> getAll(){ return carService.getAllCars(); }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CarResponse addCar(@RequestBody CarRequest carRequest){
        Car car = CAR_MAPPER.toEntity(carRequest);
        return CAR_MAPPER.toResponse(carService.create(car));
    }

    @GetMapping("/{car_id}")
    public CarResponse getCar(@PathVariable("car_id") Integer id) {
        return CAR_MAPPER.toResponse(carService.getCar(id));
    }

    @PutMapping("/{car_id}")
    public CarResponse updateTodoStatus(@PathVariable("car_id") Integer id, @RequestBody CarRequest carRequest) {
        Car car = CAR_MAPPER.toEntity(carRequest);
        Car updatedCar = carService.updateCarDetails(id, car);
        return CAR_MAPPER.toResponse(updatedCar);
    }

    @DeleteMapping("/{car_id}")
    public void deleteCar(@PathVariable Integer car_id) {
        carService.deleteCar(car_id);
    }

}

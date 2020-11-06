package com.example.MinuteManParking.controller;

import com.example.MinuteManParking.dto.CarRequest;
import com.example.MinuteManParking.dto.CarResponse;
import com.example.MinuteManParking.model.Car;
import com.example.MinuteManParking.model.Ticket;
import com.example.MinuteManParking.service.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

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
    public List<Car> getAll() {
        return carService.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CarResponse addCar(@RequestBody CarRequest carRequest) {
        Car car = CAR_MAPPER.toEntity(carRequest);
        return CAR_MAPPER.toResponse(carService.create(car));
    }

    @GetMapping("/{car_id}")
    public CarResponse getCar(@PathVariable("car_id") Integer id) {
        return CAR_MAPPER.toResponse(carService.retrieve(id));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public CarResponse update(@PathVariable Integer id, @RequestBody CarRequest carRequest) {
        Car car = carService.update(id, CAR_MAPPER.toEntity(carRequest));
        return CAR_MAPPER.toResponse(car);
    }

    @DeleteMapping("/{car_id}")
    public void deleteCar(@PathVariable Integer car_id) {
        carService.delete(car_id);
    }

    @GetMapping("/{id}/ticketList")
    public List<Ticket> getTicketList(@PathVariable Integer id) {
        return carService.getTicketByCar(id);
    }

}

package com.example.MinuteManParking.service;

import com.example.MinuteManParking.exceptions.CarNotFoundException;
import com.example.MinuteManParking.model.Car;
import com.example.MinuteManParking.model.Ticket;
import com.example.MinuteManParking.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.MinuteManParking.exceptions.ExceptionConstants.CAR_NOT_FOUND;

@Service
public class CarService {
    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> getAll() {
        return carRepository.findAll();
    }

    public Car create(Car car) {
        return carRepository.save(car);
    }

    public Car retrieve(Integer id) {
        return carRepository.findById(id).orElseThrow(() -> new CarNotFoundException(CAR_NOT_FOUND));
    }

    public Car update(Integer id, Car car) {
        Car retrievedCar = retrieve(id);
        retrievedCar.setBrand(car.getBrand());
        retrievedCar.setColor(car.getColor());
        retrievedCar.setPlateNumber(car.getPlateNumber());
        return carRepository.save(retrievedCar);
    }

    public void delete(Integer id) {
        retrieve(id);
        carRepository.deleteById(id);
    }

    public List<Ticket> getTicketByCar(Integer id) {
        return carRepository.findById(id)
                .map(Car::getTicketList)
                .orElseThrow(()-> new CarNotFoundException(CAR_NOT_FOUND));
    }
}

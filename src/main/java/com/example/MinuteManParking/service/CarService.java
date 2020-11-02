package com.example.MinuteManParking.service;

import com.example.MinuteManParking.exceptions.CarNotFoundException;
import com.example.MinuteManParking.model.Car;
import com.example.MinuteManParking.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import static com.example.MinuteManParking.exceptions.ExceptionConstants.*;

@Service
public class CarService {
    private CarRepository carRepository;

    public CarService(CarRepository carRepository){
        this.carRepository = carRepository;
    }

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    public Car create(Car car) {
        return carRepository.save(car);
    }

    public Car getCar(Integer id) {
        return carRepository.findById(id).orElseThrow(() -> new CarNotFoundException(CAR_NOT_FOUND));
    }

    public Car updateCarDetails(Integer id, Car carRequest) {
        Car car = carRepository.findById(id).orElseThrow(() ->
                new CarNotFoundException(CAR_NOT_FOUND));

        car.setBrand(carRequest.getBrand());
        car.setColor(carRequest.getColor());
        car.setPlateNumber(carRequest.getPlateNumber());
        return carRepository.save(car);
    }

    public void deleteCar(Integer id) {  carRepository.deleteById(id); }

}

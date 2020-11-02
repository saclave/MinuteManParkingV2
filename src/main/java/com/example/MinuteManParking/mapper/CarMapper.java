package com.example.MinuteManParking.mapper;

import com.example.MinuteManParking.dto.CarRequest;
import com.example.MinuteManParking.dto.CarResponse;
import com.example.MinuteManParking.model.Car;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class CarMapper {

    public Car toEntity(CarRequest carRequest) {
        Car car = new Car();
        BeanUtils.copyProperties(carRequest, car);
        return car;
    }

    public CarResponse toResponse(Car car) {
        CarResponse carResponse = new CarResponse();
        BeanUtils.copyProperties(car, carResponse);
        return carResponse;
    }

}

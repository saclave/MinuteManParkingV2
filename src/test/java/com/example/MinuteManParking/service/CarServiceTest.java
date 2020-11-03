package com.example.MinuteManParking.service;

import com.example.MinuteManParking.model.Car;
import com.example.MinuteManParking.repository.CarRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertSame;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class CarServiceTest {
    private CarRepository carRepository;
    private CarService carService;

    @BeforeEach
    void setup(){
        carRepository = mock(CarRepository.class);
        carService = new CarService(carRepository);
    }

    @Test
    void should_return_list_of_cars_when_get_all_cars_given_get_request() {
        //given
        //when
        when(carRepository.findAll()).thenReturn(asList(new Car(), new Car()));
        List<Car> carRequest = carService.getAll();
        //then
        assertEquals(2, carRequest.size());
    }

    @Test
    void should_return_created_cars_when_given_a_cars_request() {
        //given
        //when
        Car car = new Car();
        car.setPlateNumber("ABC");
        when(carRepository.save(car)).thenReturn(car);
        Car actual = carService.create(car);

        //then
        assertEquals("ABC", actual.getPlateNumber());
    }

    @Test
    void should_return_updated_cars_info_when_given_an_cars_request() {
        //given
        Car carRequest = new Car();
        carRequest.setId(1);
        Car expectedCar = new Car();
        expectedCar.setId(1);
        when(carRepository.findById(1)).thenReturn(Optional.of(carRequest));
        when(carRepository.save(carRequest)).thenReturn(expectedCar);

        //when
        Car updatedCar = carService.update(carRequest.getId(), expectedCar);

        //then
        assertSame(expectedCar, updatedCar);
    }

    @Test
    void should_remove_cars_when_delete_given_id(){
        //given
        Car car = new Car();
        car.setId(69);

        //when
        when(carRepository.findById(car.getId())).thenReturn(Optional.of(car));
        carService.delete(car.getId());

        //then
        verify(carRepository, times(1)).deleteById(69);
    }


}

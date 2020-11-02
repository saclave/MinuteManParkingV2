package com.example.MinuteManParking.advice;

public class CarNotFoundException extends RuntimeException {
    public static final String CAR_NOT_FOUND = "Car Not Found.";

    public CarNotFoundException(String message){
        super(message);
    }
}

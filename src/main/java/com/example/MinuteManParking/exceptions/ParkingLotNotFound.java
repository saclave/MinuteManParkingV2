package com.example.MinuteManParking.exceptions;

public class ParkingLotNotFound extends RuntimeException {

    public ParkingLotNotFound(String message) {
        super(message);
    }
}

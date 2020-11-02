package com.example.MinuteManParking.exceptions;

public class ParkingSlotNotFound extends RuntimeException {

    public ParkingSlotNotFound(String message) {
        super(message);
    }
}

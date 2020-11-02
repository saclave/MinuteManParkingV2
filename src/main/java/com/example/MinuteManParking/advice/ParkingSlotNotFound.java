package com.example.MinuteManParking.advice;

public class ParkingSlotNotFound extends RuntimeException {
    public static final String PARKING_SLOT_NOT_FOUND = "Parking Slot Not Found";

    public ParkingSlotNotFound(String message) {
        super(message);
    }
}

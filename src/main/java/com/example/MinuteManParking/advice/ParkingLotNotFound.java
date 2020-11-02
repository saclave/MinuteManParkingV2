package com.example.MinuteManParking.advice;

public class ParkingLotNotFound extends RuntimeException {
    public static final String PARKING_LOT_NOT_FOUND = "Parking Lot Not Found";

    public ParkingLotNotFound(String message) {
        super(message);
    }
}

package com.example.MinuteManParking.exceptions;

public class TicketNotFound extends RuntimeException {

    public TicketNotFound(String message) {
        super(message);
    }
}

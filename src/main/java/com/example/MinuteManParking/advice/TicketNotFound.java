package com.example.MinuteManParking.advice;

public class TicketNotFound extends RuntimeException {
    public static final String TICKET_NOT_FOUND = "Ticket Not Found";

    public TicketNotFound(String message) {
        super(message);
    }
}

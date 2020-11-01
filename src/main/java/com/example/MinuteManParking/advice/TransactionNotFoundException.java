package com.example.MinuteManParking.advice;

public class TransactionNotFoundException extends RuntimeException{
    public static final String TRANSACTION_NOT_FOUND = "Transaction Not Found";
    public static final String TICKET_NOT_FOUND = "Ticket Not Found";
    public static final String USER_NOT_FOUND = "User Not Found";

    public TransactionNotFoundException(String message) {
        super(message);
    }
}

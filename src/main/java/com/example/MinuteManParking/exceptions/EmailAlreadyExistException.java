package com.example.MinuteManParking.exceptions;

public class EmailAlreadyExistException extends RuntimeException {
    public static final String EMAIL_ALREADY_EXISTING = "Email Address Already Existing";

    public EmailAlreadyExistException(String message) {
        super(message);
    }
}

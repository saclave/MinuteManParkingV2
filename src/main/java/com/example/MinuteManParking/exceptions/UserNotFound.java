package com.example.MinuteManParking.exceptions;

public class UserNotFound extends RuntimeException {
    public static final String USER_NOT_FOUND = "User Not Found";
    public UserNotFound(String message) {
        super(message);
    }
}

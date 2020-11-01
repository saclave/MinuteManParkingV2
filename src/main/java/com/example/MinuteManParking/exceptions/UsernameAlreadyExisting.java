package com.example.MinuteManParking.exceptions;

public class UsernameAlreadyExisting extends RuntimeException{
    public static final String USERNAME_ALREADY_EXISTING = "Username Already Existing";
    public UsernameAlreadyExisting(String message) {
        super(message);
    }
}

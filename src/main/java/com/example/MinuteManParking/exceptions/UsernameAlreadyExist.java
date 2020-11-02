package com.example.MinuteManParking.exceptions;

public class UsernameAlreadyExist extends RuntimeException{
    public static final String USERNAME_ALREADY_EXISTING = "Username Already Existing";

    public UsernameAlreadyExist(String message) {
        super(message);
    }
}

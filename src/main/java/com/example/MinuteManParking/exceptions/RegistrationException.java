package com.example.MinuteManParking.exceptions;

import com.example.MinuteManParking.dto.UserCreationErrorResponse;

public class RegistrationException extends RuntimeException {
    private UserCreationErrorResponse userCreationErrorResponse;

    public RegistrationException(UserCreationErrorResponse userCreationErrorResponse) {
        this.userCreationErrorResponse = userCreationErrorResponse;
    }

    public UserCreationErrorResponse getUserCreationErrorResponse() {
        return userCreationErrorResponse;
    }
}

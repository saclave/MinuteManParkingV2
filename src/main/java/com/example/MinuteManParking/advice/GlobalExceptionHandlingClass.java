package com.example.MinuteManParking.advice;

import com.example.MinuteManParking.dto.UserCreationErrorResponse;
import com.example.MinuteManParking.exceptions.CarNotFoundException;
import com.example.MinuteManParking.exceptions.HazardNotFound;
import com.example.MinuteManParking.exceptions.ParkingLotNotFound;
import com.example.MinuteManParking.exceptions.ParkingSlotNotFound;
import com.example.MinuteManParking.exceptions.RegistrationException;
import com.example.MinuteManParking.exceptions.TicketNotFound;
import com.example.MinuteManParking.exceptions.UserNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandlingClass {
    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleUserNotFoundException(UserNotFound exception) {
        return new ErrorResponse(exception.getMessage(), HttpStatus.NOT_FOUND.name());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.OK)
    public UserCreationErrorResponse handleAlreadyExistingException(RegistrationException exception) {
        return exception.getUserCreationErrorResponse();
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleCarNotFoundException(CarNotFoundException exception) {
        return new ErrorResponse(exception.getMessage(), HttpStatus.NOT_FOUND.name());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleParkingLotNotFoundException(ParkingLotNotFound exception) {
        return new ErrorResponse(exception.getMessage(), HttpStatus.NOT_FOUND.name());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleParkingSlotNotFoundException(ParkingSlotNotFound exception) {
        return new ErrorResponse(exception.getMessage(), HttpStatus.NOT_FOUND.name());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleTicketNotFoundException(TicketNotFound exception) {
        return new ErrorResponse(exception.getMessage(), HttpStatus.NOT_FOUND.name());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleHazardNotFoundException(HazardNotFound exception) {
        return new ErrorResponse(exception.getMessage(), HttpStatus.NOT_FOUND.name());
    }
}

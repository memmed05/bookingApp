package com.example.bookingApp.exceptions;

public class NotEnoughSeatsException extends Exception {
    public NotEnoughSeatsException(String error) {
        super(error);
    }
}

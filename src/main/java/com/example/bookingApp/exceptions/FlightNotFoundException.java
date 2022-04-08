package com.example.bookingApp.exceptions;

import javax.persistence.EntityNotFoundException;

public class FlightNotFoundException extends Exception {
    public FlightNotFoundException(String error){
        super(error);
    }
}

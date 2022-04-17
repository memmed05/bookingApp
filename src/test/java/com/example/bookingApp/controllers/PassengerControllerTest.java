package com.example.bookingApp.controllers;

import com.example.bookingApp.entities.Passenger;
import com.example.bookingApp.services.PassengerService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PassengerControllerTest {

    @Mock
    private PassengerService passengerService;

    @InjectMocks
    private PassengerController passengerController;

    @Test
    void getAllPassengers() {
        List<Passenger> passengers=List.of(
                new Passenger()
        );

        Mockito.when(passengerService.getAllPassengers()).thenReturn(passengers);
        Assertions.assertDoesNotThrow(()->passengerController.getAllPassengers());
    }

    @Test
    void addPassenger() {
        Passenger passenger=new Passenger();
        Mockito.when(passengerService.addPassenger(1,passenger)).thenReturn("data added");
        Assertions.assertDoesNotThrow(()->passengerController.addPassenger(1,passenger));
    }

    @Test
    void removePassenger() {
        Mockito.when(passengerService.deletePassenger(1)).thenReturn("data removed");
        Assertions.assertDoesNotThrow(()->passengerService.deletePassenger(1));
    }
}
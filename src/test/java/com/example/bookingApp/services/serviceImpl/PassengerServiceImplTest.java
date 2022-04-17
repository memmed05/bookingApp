package com.example.bookingApp.services.serviceImpl;

import com.example.bookingApp.entities.Passenger;
import com.example.bookingApp.entities.User;
import com.example.bookingApp.repositories.PassengerRepository;
import com.example.bookingApp.repositories.UserRepository;
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
class PassengerServiceImplTest {

    @Mock
    private PassengerRepository passengerRepository;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private PassengerServiceImpl passengerService;

    @Test
    void getAllPassengers() {
        List<Passenger> passengers = List.of(
                new Passenger()
        );
        Mockito.when(passengerRepository.findAll()).thenReturn(passengers);
        Assertions.assertDoesNotThrow(()->passengerService.getAllPassengers());
    }

    @Test
    void addPassenger(){
        User user=userRepository.getById(1);
        Passenger passenger=new Passenger();
        passenger.setUser(user);
        Mockito.when(passengerRepository.save(passenger)).thenReturn(passenger);
        Assertions.assertDoesNotThrow(()->passengerService.addPassenger(1,passenger));
    }

}
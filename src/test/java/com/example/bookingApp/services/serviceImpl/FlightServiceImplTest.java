package com.example.bookingApp.services.serviceImpl;

import com.example.bookingApp.entities.Flight;
import com.example.bookingApp.repositories.FlightRepository;
import com.example.bookingApp.services.FlightService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FlightServiceImplTest {

    @Mock
    FlightRepository flightRepository;

    FlightService flightService;

    @BeforeEach
    void initUseCase() {
         flightService= new FlightServiceImpl(flightRepository);
    }

    @Test
    void addFlight() {
        Flight flight = new Flight();
        flight.setFlightId(3);
        flight.setDestinationPoint("Roma");
        flight.setDate(LocalDate.parse("2022-04-25"));
        when(flightRepository.save(any(Flight.class))).thenReturn(flight);

        Flight savedFlight = flightRepository.save(flight);
        assertThat(savedFlight.getDestinationPoint()).isNotNull();
    }


}
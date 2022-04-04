package com.example.bookingApp.services;

import com.example.bookingApp.entities.Flight;

import java.util.List;

public interface FlightService {
    String addFlight(Flight flight);
    List<Flight>getAllFlights();
    String removeFlight(Integer id);
}

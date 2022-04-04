package com.example.bookingApp.services;

import com.example.bookingApp.entities.Flight;
import com.example.bookingApp.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightServiceImpl implements FlightService {

    private final FlightRepository flightRepository;

    @Autowired
    public FlightServiceImpl(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @Override
    public String addFlight(Flight flight) {
        this.flightRepository.save(flight);
        return "data added";
    }

    @Override
    public List<Flight> getAllFlights() {
        return this.flightRepository.findAll();
    }

    @Override
    public String removeFlight(Integer id) {
        this.flightRepository.deleteById(id);
        return "data removed";
    }
}

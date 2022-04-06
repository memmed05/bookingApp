package com.example.bookingApp.services.serviceImpl;

import com.example.bookingApp.entities.Flight;
import com.example.bookingApp.repositories.FlightRepository;
import com.example.bookingApp.services.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FlightServiceImpl implements FlightService {

    private final FlightRepository flightRepository;

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

    @Override
    public Flight getFlightById(Integer id) {
        return this.flightRepository.getById(id);
    }
}

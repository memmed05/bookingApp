package com.example.bookingApp.controllers;

import com.example.bookingApp.services.FlightService;
import com.example.bookingApp.services.FlightServiceImpl;
import com.example.bookingApp.entities.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/flight")
public class FlightController {

    private final FlightService flightService;

    @Autowired
    public FlightController(FlightServiceImpl flightService) {
        this.flightService = flightService;
    }

    @GetMapping(value = "/getAllFlights")
    public List<Flight> getAllFlights() {
        return this.flightService.getAllFlights();
    }

    @PostMapping(value = "/add")
    public String addFlight(@RequestBody Flight flight) {
        return this.flightService.addFlight(flight);
    }

    @DeleteMapping(value = "removeFlight/{id}")
    public String removeFlight(@PathVariable Integer id) {
        return this.flightService.removeFlight(id);
    }
}

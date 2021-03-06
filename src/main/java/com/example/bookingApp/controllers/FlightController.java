package com.example.bookingApp.controllers;

import com.example.bookingApp.services.FlightService;
import com.example.bookingApp.entities.Flight;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/flight")
@RequiredArgsConstructor
public class FlightController {

    private final FlightService flightService;

    @GetMapping(value = "/getAllFlights")
    public ResponseEntity<List<Flight>> getAllFlights() {
        return ResponseEntity.ok(this.flightService.getAllFlights());
    }

    @GetMapping(value = "/getFlightById")
    public ResponseEntity<Flight> getFlightById(@RequestParam(value = "flightId", required = true) Integer id) {
        return ResponseEntity.ok(this.flightService.getFlightById(id));
    }

    @PostMapping(value = "/add")
    public ResponseEntity<String> addFlight(@RequestBody Flight flight) {
        return ResponseEntity.ok(this.flightService.addFlight(flight));
    }

    @DeleteMapping(value = "removeFlight/{id}")
    public ResponseEntity<String> removeFlight(@PathVariable Integer id) {
        return ResponseEntity.ok(this.flightService.removeFlight(id));
    }


}

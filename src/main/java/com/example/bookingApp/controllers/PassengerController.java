package com.example.bookingApp.controllers;

import com.example.bookingApp.entities.Passenger;
import com.example.bookingApp.services.PassengerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/passenger")
@RequiredArgsConstructor
public class PassengerController {

    public final PassengerService passengerService;

    @GetMapping(value = "/getAllPassengers")
    public ResponseEntity<List<Passenger>> getAllPassengers() {
        return ResponseEntity.ok(this.passengerService.getAllPassengers());
    }

    @PostMapping(value = "/addPassenger")
    public ResponseEntity<String> addPassenger(
            @RequestParam Integer id,
            @RequestBody Passenger passenger) {
        return ResponseEntity.ok(this.passengerService.addPassenger(id,passenger));
    }

    @DeleteMapping(value = "/removePassenger/{id}")
    public ResponseEntity<String > removePassenger(@PathVariable Integer id) {
        return ResponseEntity.ok(this.passengerService.deletePassenger(id));
    }

}

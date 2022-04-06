package com.example.bookingApp.controllers;

import com.example.bookingApp.dtos.BoardDto;
import com.example.bookingApp.dtos.BookingDto;
import com.example.bookingApp.entities.Passenger;
import com.example.bookingApp.services.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/passenger")
public class PassengerController {

    public final PassengerService passengerService;

    @Autowired
    public PassengerController(PassengerService passengerService) {
        this.passengerService = passengerService;
    }

    @GetMapping(value = "/getAllPassengers")
    public ResponseEntity<List<Passenger>> getAllPassengers() {
        return ResponseEntity.ok(this.passengerService.getAllPassengers());
    }

/*    @PostMapping(value = "/buyTicket")
    public String buyTicket(
            @RequestParam Integer id,
            @RequestBody BookingDto bookingDto) {
            return this.passengerService.buyTicket(id,bookingDto);
    }*/

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

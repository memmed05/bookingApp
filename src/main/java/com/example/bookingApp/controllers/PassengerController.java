package com.example.bookingApp.controllers;

import com.example.bookingApp.entities.Passenger;
import com.example.bookingApp.services.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Passenger> getAllPassengers(){
        return this.passengerService.getAllPassengers();
    }

    @PostMapping(value = "/addPassenger")
    public String addPassenger(@RequestBody Passenger passenger){
        return this.passengerService.addPassenger(passenger);
    }

    @DeleteMapping(value = "/removePassenger/{id}")
    public String removePassenger(@PathVariable Integer id){
        return this.passengerService.deletePassenger(id);
    }

}

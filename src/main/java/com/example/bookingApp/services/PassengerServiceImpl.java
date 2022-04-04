package com.example.bookingApp.services;

import com.example.bookingApp.entities.Passenger;
import com.example.bookingApp.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassengerServiceImpl implements PassengerService {

    private final PassengerRepository passengerRepository;

    @Autowired
    public PassengerServiceImpl(PassengerRepository passengerRepository) {
        this.passengerRepository = passengerRepository;
    }

    @Override
    public String addPassenger(Passenger passenger) {
        this.passengerRepository.save(passenger);
        return "data added";
    }

    @Override
    public List<Passenger> getAllPassengers() {
        return this.passengerRepository.findAll();
    }

    @Override
    public String deletePassenger(Integer id) {
        this.passengerRepository.deleteById(id);
        return "data removed";
    }
}

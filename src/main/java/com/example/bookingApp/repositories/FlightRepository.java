package com.example.bookingApp.repositories;

import com.example.bookingApp.entities.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FlightRepository extends JpaRepository<Flight,Integer> {
    Optional<Flight> findByFlightId(Integer id);
}

package com.example.bookingApp.repositories;

import com.example.bookingApp.entities.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight,Integer> {

}

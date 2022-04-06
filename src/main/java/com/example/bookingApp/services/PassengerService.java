package com.example.bookingApp.services;

import com.example.bookingApp.dtos.BookingDto;
import com.example.bookingApp.entities.Passenger;

import java.util.List;

public interface PassengerService {
    String addPassenger(Integer id,Passenger passenger);

    List<Passenger> getAllPassengers();

    String deletePassenger(Integer id);

   /* String buyTicket(Integer id, BookingDto bookingDto);*/

}

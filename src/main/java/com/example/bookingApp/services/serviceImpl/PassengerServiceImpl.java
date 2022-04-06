package com.example.bookingApp.services.serviceImpl;

import com.example.bookingApp.dtos.BookingDto;
import com.example.bookingApp.entities.Passenger;
import com.example.bookingApp.entities.User;
import com.example.bookingApp.repositories.PassengerRepository;
import com.example.bookingApp.repositories.UserRepository;
import com.example.bookingApp.services.PassengerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PassengerServiceImpl implements PassengerService {

    private final PassengerRepository passengerRepository;
    private final UserRepository userRepository;

    @Override
    public String addPassenger(Integer id,Passenger passenger) {
        User user=this.userRepository.getById(id);
        passenger.setUser(user);
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

 /*   @Override
    public String buyTicket(Integer id, BookingDto bookingDto) {
        User user=userRepository.getById(id);
        Passenger passenger=new Passenger();
        passenger.
        passenger.setUser(user);
        return "success";
    }*/
}

package com.example.bookingApp.services.serviceImpl;


import com.example.bookingApp.dtos.BoardDto;
import com.example.bookingApp.dtos.BookingDto;
import com.example.bookingApp.entities.Flight;
import com.example.bookingApp.entities.Passenger;
import com.example.bookingApp.entities.User;
import com.example.bookingApp.repositories.FlightRepository;
import com.example.bookingApp.repositories.UserRepository;
import com.example.bookingApp.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final FlightRepository flightRepository;


    @Override
    public String createUser(User user) {
        this.userRepository.save(user);
        return "data added";
    }

    @Override
    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }


    @Override
    public String removeUser(Integer id) {
        this.userRepository.deleteById(id);
        return "data removed";
    }

    @Override
    public String book(Integer id, BoardDto boardDto) {
        Flight flight = this.flightRepository.getById(id);
        User user = this.userRepository.getById(boardDto.getUserId());
        if (flight.getFreeSeats() < boardDto.getNumberOfPeople()) {
            return "failed";
        }
        user.setFlight(flight);
        flight.setFreeSeats(flight.getFreeSeats()-boardDto.getNumberOfPeople());
        this.userRepository.save(user);
        return "success";
    }


}

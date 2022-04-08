package com.example.bookingApp.services.serviceImpl;


import com.example.bookingApp.dtos.BoardDto;
import com.example.bookingApp.entities.Flight;
import com.example.bookingApp.entities.User;
import com.example.bookingApp.exceptions.FlightNotFoundException;
import com.example.bookingApp.exceptions.NotEnoughSeatsException;
import com.example.bookingApp.repositories.FlightRepository;
import com.example.bookingApp.repositories.UserRepository;
import com.example.bookingApp.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

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
    public String book(Integer id, BoardDto boardDto) throws FlightNotFoundException, NotEnoughSeatsException {
        Optional<Flight> flight = flightRepository.findByFlightId(id);
        User user = this.userRepository.getById(boardDto.getUserId());
        if (flight.isPresent()) {
            if (flight.get().getFreeSeats() < boardDto.getNumberOfPeople()) {
                throw new NotEnoughSeatsException("there is not enough seat");
            }
            user.setFlight(flight.get());
            flight.get().setFreeSeats(flight.get().getFreeSeats() - boardDto.getNumberOfPeople());
            this.userRepository.save(user);
            return "success";
        } else {
            throw new FlightNotFoundException("flight not found");
        }
    }


}

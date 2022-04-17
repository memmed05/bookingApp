package com.example.bookingApp.services.serviceImpl;

import com.example.bookingApp.dtos.BoardDto;
import com.example.bookingApp.entities.Flight;
import com.example.bookingApp.entities.User;
import com.example.bookingApp.repositories.FlightRepository;
import com.example.bookingApp.repositories.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private FlightRepository flightRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    void createUser() {
        User user = new User();
        Mockito.when(userRepository.save(user)).thenReturn(user);
        Assertions.assertDoesNotThrow(() -> userService.createUser(user));
    }

    @Test
    void getAllUsers() {
        List<User> users = List.of(
                new User()
        );
        Mockito.when(userRepository.findAll()).thenReturn(users);
        Assertions.assertDoesNotThrow(() -> userService.getAllUsers());
    }


    @Test
    void book() {
        BoardDto boardDto = new BoardDto(
                1,
                5,
                "baku",
                LocalDate.of(2022, 04, 15),
                LocalTime.of(15, 22));
        User user = userRepository.getById(boardDto.getUserId());
        Flight flight = flightRepository.getById(1);
        user.setFlight(flight);
        flight.setFreeSeats(flight.getFreeSeats() - boardDto.getNumberOfPeople());
        Mockito.when(userRepository.save(user)).thenReturn(user);
        Assertions.assertDoesNotThrow(() -> userService.book(1, boardDto));
    }

}
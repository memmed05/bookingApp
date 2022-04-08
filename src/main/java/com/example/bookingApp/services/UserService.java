package com.example.bookingApp.services;

import com.example.bookingApp.dtos.BoardDto;
import com.example.bookingApp.entities.User;
import com.example.bookingApp.exceptions.FlightNotFoundException;
import com.example.bookingApp.exceptions.NotEnoughSeatsException;

import java.util.List;

public interface UserService {
    String createUser(User user);

    List<User> getAllUsers();

    String removeUser(Integer id);

    String  book(Integer id, BoardDto boardDto) throws FlightNotFoundException, NotEnoughSeatsException;
}

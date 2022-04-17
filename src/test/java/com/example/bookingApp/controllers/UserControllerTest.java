package com.example.bookingApp.controllers;

import com.example.bookingApp.dtos.BoardDto;
import com.example.bookingApp.entities.User;
import com.example.bookingApp.exceptions.FlightNotFoundException;
import com.example.bookingApp.exceptions.NotEnoughSeatsException;
import com.example.bookingApp.services.UserService;
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
class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;


    @Test
    void getAllUsers() {
        List<User> users = List.of(
                new User()
        );

        Mockito.when(userService.getAllUsers()).thenReturn(users);
        Assertions.assertDoesNotThrow(() -> userController.getAllUsers());
    }

    @Test
    void createUser() {
        User user = new User();
        Mockito.when(userService.createUser(user)).thenReturn("data added");
        Assertions.assertDoesNotThrow(() -> userController.createUser(user));
    }

    @Test
    void removeUser() {
        Mockito.when(userService.removeUser(1)).thenReturn("data removed");
        Assertions.assertDoesNotThrow(() -> userController.removeUser(1));
    }

    @Test
    void book() throws FlightNotFoundException, NotEnoughSeatsException {
        BoardDto boardDto = new BoardDto(
                1,
                5,
                "baku",
                LocalDate.of(2022,04,15),
                LocalTime.of(15,22));
        Mockito.when(userService.book(1, boardDto)).thenReturn("data added");
        Assertions.assertDoesNotThrow(()->userController.book(1,boardDto));
    }
}
package com.example.bookingApp.services;

import com.example.bookingApp.entities.User;

import java.util.List;

public interface UserService {
    String createUser(User user);

    List<User> getAllUsers();

    String removeUser(Integer id);
}

package com.example.bookingApp.services;

import com.example.bookingApp.entities.User;
import com.example.bookingApp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

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
        return "data remove";
    }
}

package com.example.bookingApp.controllers;

import com.example.bookingApp.entities.User;
import com.example.bookingApp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "api/v1/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/getAllUsers")
    public List<User> getAllUsers(){
        return this.userService.getAllUsers();
    }

    @PostMapping(value = "/createUser")
    public String createUser(@RequestBody User user){
        return this.userService.createUser(user);
    }

    @DeleteMapping(value = "/removeUser/{id}")
    public String removeUser(@PathVariable Integer id){
        return this.userService.removeUser(id);
    }
}

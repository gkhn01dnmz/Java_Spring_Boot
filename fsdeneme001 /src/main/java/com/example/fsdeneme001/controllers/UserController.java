package com.example.fsdeneme001.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.fsdeneme001.entities.User;

import com.example.fsdeneme001.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
    
    
    private UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping
    public Iterable<User> getAllUsers() {
        return userService.getAll();
    }

    @GetMapping("/{userId}")
    public User getOneUserById(@PathVariable("userId") Long userId) {
            return userService.getOneUserById(userId);
    }

    @PostMapping
    public User createOneUser(@RequestBody User user) {
        return userService.createOneUser(user);
    }

    @PutMapping("/{userId}")
    public User updateOneUser(@PathVariable("userId") Long userId, @RequestBody User userDetails) {
        return userService.updateOneUserById(userId, userDetails);
    }

    @DeleteMapping("/{userId}")
    public void deleteOneUserById(@PathVariable("userId") Long userId) {
        userService.deleteOneUserById(userId);
    }



}

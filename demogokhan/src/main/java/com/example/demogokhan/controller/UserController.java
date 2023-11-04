package com.example.demogokhan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demogokhan.entities.User;
import com.example.demogokhan.repos.UserRepo;

@RestController
@RequestMapping("/user")
public class UserController {
    

    @Autowired
    UserRepo userRepo;

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody User user) {
        return new ResponseEntity<User>(userRepo.save(user),HttpStatus.OK);
    }
    
}

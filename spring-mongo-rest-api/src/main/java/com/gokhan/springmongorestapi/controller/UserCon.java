package com.gokhan.springmongorestapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.gokhan.springmongorestapi.entities.User;
import com.gokhan.springmongorestapi.repos.UserRepository;

@RestController
@RequestMapping("/user")
public class UserCon {
    
    @Autowired
    private  UserRepository userRepository;

    @PostMapping
    public ResponseEntity<User> addOneUser(@RequestBody User user) {
        return  ResponseEntity.ok(userRepository.save(user));
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return  ResponseEntity.ok(userRepository.findAll());
    }


}

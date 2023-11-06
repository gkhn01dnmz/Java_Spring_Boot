package com.gokhan.springpostgrerest.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gokhan.springpostgrerest.dto.UserDto;
import com.gokhan.springpostgrerest.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
@PostMapping
public ResponseEntity<UserDto> addOneUser(@RequestBody UserDto userDto) {
    return ResponseEntity.ok(userService.save(userDto));
}

@GetMapping
public ResponseEntity<List<UserDto>> listAllUsers(){
    return ResponseEntity.ok(userService.getAll());
}

}

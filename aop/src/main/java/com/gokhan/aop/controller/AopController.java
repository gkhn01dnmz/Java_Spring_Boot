package com.gokhan.aop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gokhan.aop.service.MessageService;



@RestController
@RequestMapping("/mesaj")
public class AopController {


    @Autowired
    private MessageService messageService;


    @PostMapping
    public ResponseEntity<String> ornekMethod(@RequestBody String message) {
        return ResponseEntity.ok(messageService.mesajVer(message));
    }
}

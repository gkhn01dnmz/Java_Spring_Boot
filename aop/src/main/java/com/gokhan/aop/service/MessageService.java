package com.gokhan.aop.service;

import org.springframework.stereotype.Service;

@Service
public class MessageService {

    public String  mesajVer(String message) {
        System.out.println("method mesaj verdi param:" +message);
        return message;
    }
}

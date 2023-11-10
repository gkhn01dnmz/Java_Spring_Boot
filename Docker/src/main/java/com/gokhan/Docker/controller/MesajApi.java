package com.gokhan.Docker.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mesaj")
public class MesajApi {
    


    @GetMapping
    public String mesajVer(){
        return "Docker Imageminin içerisinden merhaba";
    }
}

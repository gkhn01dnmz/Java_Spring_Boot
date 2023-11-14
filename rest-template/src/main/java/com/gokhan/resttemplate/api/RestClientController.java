package com.gokhan.resttemplate.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.gokhan.resttemplate.model.UserDto;

@Controller
@RequestMapping("/test")
public class RestClientController {
    
    @Autowired
    private RestTemplate restTemplate;

    private static final String webUrl = "http://localhost:8090/user";
    
    @GetMapping
    public ResponseEntity<List<UserDto>>  getUsers(){
        ResponseEntity<List> result= restTemplate.getForEntity(webUrl,List.class);
        System.out.println(result);
        return null;
    }

}

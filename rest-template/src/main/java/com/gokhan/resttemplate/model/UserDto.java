package com.gokhan.resttemplate.model;

import java.util.List;

import lombok.Data;

@Data
public class UserDto {
    private Long id;


    private String name;


    private String surname;


    private List<String> addresses;
}

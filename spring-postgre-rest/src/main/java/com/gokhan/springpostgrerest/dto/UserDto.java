package com.gokhan.springpostgrerest.dto;

import java.util.ArrayList;
import java.util.List;

import com.gokhan.springpostgrerest.entities.Address;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Data;


@Data
public class UserDto {

    private Long id;


    private String name;


    private String surname;


    private List<String> addresses;
}

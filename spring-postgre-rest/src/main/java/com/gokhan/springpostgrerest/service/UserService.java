package com.gokhan.springpostgrerest.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.gokhan.springpostgrerest.dto.UserDto;

public interface UserService {
    UserDto save(UserDto userDto);
    void delete();
    List<UserDto> getAll();
    Page<UserDto> getAll(Pageable pageable);
}

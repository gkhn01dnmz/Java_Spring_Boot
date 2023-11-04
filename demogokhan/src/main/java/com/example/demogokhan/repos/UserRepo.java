package com.example.demogokhan.repos;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demogokhan.entities.User;

public interface UserRepo extends MongoRepository<User,String>{
    
}

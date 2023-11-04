package com.gokhan.springmongorestapi.repos;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.gokhan.springmongorestapi.entities.User;

public interface UserRepository extends MongoRepository<User,String> {
    
}

package com.gokhan.springpostgrerest.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gokhan.springpostgrerest.entities.User;

public interface UserRepository  extends JpaRepository<User,Long>{
    
}

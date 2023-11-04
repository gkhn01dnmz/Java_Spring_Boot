package com.example.fsdeneme001.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.fsdeneme001.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
    
}

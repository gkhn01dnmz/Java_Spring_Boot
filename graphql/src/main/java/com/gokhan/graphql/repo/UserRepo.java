package com.gokhan.graphql.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gokhan.graphql.model.User;


public interface UserRepo extends JpaRepository<User,Long> {
    
}

package com.gokhan.graphql.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gokhan.graphql.model.User;
import com.gokhan.graphql.model.UserRequest;
import com.gokhan.graphql.repo.UserRepo;

@Service
public class UserService {
    
@Autowired
private  UserRepo userRepo;

public List<User> getAllUsers() {
    return userRepo.findAll();
}



public User getUserById(Long id) {
    try {
        Optional<User> userOptional = userRepo.findById(id);

        // Check if the user is present in the Optional
        if (userOptional.isPresent()) {
            return userOptional.get(); // Return the User if present
        } else {
            // Throw an exception if the User is not found
            throw new RuntimeException("User not found with id: " + id);
        }
    } catch (Exception e) {
        // Handle any other exceptions that might occur during the retrieval
        throw new RuntimeException("Error while fetching user by id", e);
    }
}


public User createUser(UserRequest userRequest) {
    User user=User.builder()
                  .username(userRequest.getUsername())
                  .mail(userRequest.getMail())
                  .role(userRequest.getRole())
                  .build();
    return userRepo.save(user);
}

public User updateUser(UserRequest userRequest) {
    User existing=getUserById(userRequest.getId());
    existing.setRole(userRequest.getRole());
    existing.setUsername(userRequest.getUsername());
    existing.setMail(userRequest.getMail());
    return userRepo.save(existing);
}

public void deleteUser(Long id) {
    User existing=getUserById(id);
    userRepo.delete(existing);
}


}

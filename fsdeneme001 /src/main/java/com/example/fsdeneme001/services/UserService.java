package com.example.fsdeneme001.services;

import org.springframework.stereotype.Service;

import com.example.fsdeneme001.entities.User;
import com.example.fsdeneme001.repos.UserRepository;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Iterable<User> getAll() {
        return userRepository.findAll();
    }

    public User getOneUserById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    public User createOneUser(User user) {
        return userRepository.save(user);
    }

    public void deleteOneUserById(Long userId) {
        userRepository.deleteById(userId);
    }

    public User updateOneUserById(Long userId, User userDetails) {
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("User not found"));
        user.setUserName(userDetails.getUserName());
        user.setPassword(userDetails.getPassword());
        return userRepository.save(user);
    }

}

package com.gokhan.graphql.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.gokhan.graphql.model.User;
import com.gokhan.graphql.model.UserRequest;
import com.gokhan.graphql.service.UserService;

@Controller
public class UserController {

@Autowired
private  UserService userService;

@QueryMapping
List<User> getAllUsers(){
    return userService.getAllUsers();
}


@QueryMapping
User getUserById(@Argument Long id){
    return userService.getUserById(id);
}


@MutationMapping
User createUser(@Argument UserRequest userRequest){
    return userService.createUser(userRequest);
}


@MutationMapping
User updateUser(@Argument UserRequest userRequest){
    return userService.updateUser(userRequest);
}


@MutationMapping
Boolean deleteUser(@Argument Long id){
     userService.deleteUser(id);
     return true;
}




}

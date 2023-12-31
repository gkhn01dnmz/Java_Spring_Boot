package com.gokhan.springmongo.repos;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.gokhan.springmongo.models.TodoDTO;



public interface TodoRepository extends MongoRepository<TodoDTO,String> {
    @Query("{'todo':?0}")
    Optional<TodoDTO> findByTodo(String todo);
}

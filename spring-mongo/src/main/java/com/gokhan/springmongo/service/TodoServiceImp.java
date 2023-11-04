package com.gokhan.springmongo.service;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gokhan.springmongo.exception.TodoCollectionException;
import com.gokhan.springmongo.models.TodoDTO;
import com.gokhan.springmongo.repos.TodoRepository;

import jakarta.validation.ConstraintViolationException;

@Service
public class TodoServiceImp implements TodoService {
@Autowired
private  TodoRepository todoRepo;


    @Override
    public void createTodo(TodoDTO todo)throws ConstraintViolationException, TodoCollectionException{
        Optional<TodoDTO> todoOptinal = todoRepo.findByTodo(todo.getTodo());
        if(todoOptinal.isPresent()){
           throw new TodoCollectionException(TodoCollectionException.TodoAlreadyExistsException());
        }else{
            todo.setCreatedAt(new Date(System.currentTimeMillis()));
            todoRepo.save(todo);
        }
    }


    @Override
    public List<TodoDTO> getAllTodos() {
        // TODO Auto-generated method stub
        List<TodoDTO> todos=todoRepo.findAll();
        if(todos.size()>0){
            return todos;
        }else{
            return new ArrayList<TodoDTO>();
        }
    }


    @Override
    public TodoDTO getSingleTodo(String id) throws TodoCollectionException {
        Optional<TodoDTO> optTodo=todoRepo.findById(id);
        if(!optTodo.isPresent()) {
            throw new TodoCollectionException(TodoCollectionException.NotFoundException(id));
        }else{
            return optTodo.get();
        }
    }


    @Override
    public void updateTodo(String id, TodoDTO todo) throws TodoCollectionException {
        Optional <TodoDTO> optinalTodo= todoRepo.findById(id);
        Optional <TodoDTO> todoWithSameName= todoRepo.findById(id);
        if(optinalTodo.isPresent()){

            if(optinalTodo.isPresent() && !todoWithSameName.get().getId().equals(id))
            {
                throw new TodoCollectionException(TodoCollectionException.TodoAlreadyExistsException());
            }
              TodoDTO todoToUpdate = optinalTodo.get();


              todoToUpdate.setTodo(todo.getTodo());
              todoToUpdate.setDescription(todo.getDescription());
              todoToUpdate.setCompleted(todo.getCompleted());
              todoToUpdate.setUpdatedAt(new Date(System.currentTimeMillis()));
              todoRepo.save(todoToUpdate);

        }else{
            throw new TodoCollectionException(TodoCollectionException.NotFoundException(id));
        }
    }


    @Override
    public void deleteTodoById(String id) throws TodoCollectionException {
        Optional <TodoDTO> optinalTodo= todoRepo.findById(id);
        if(!optinalTodo.isPresent()) {
            throw new TodoCollectionException(TodoCollectionException.NotFoundException(id));
        }else{
            todoRepo.deleteById(id);
        }
    }
}

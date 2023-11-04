package com.example.fsdeneme001.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.fsdeneme001.entities.Post;


public interface PostRepository extends JpaRepository<Post, Long> {

    Iterable<Post> findByUserId(Long userId);// Jpa FindBy'dan sonraki propların methodunu kendisi yapıyor.
                                            //kendim yapsaydım post içindeki instanceların user ıd lerini 
                                            //foreach ile tarardım

   
    
}

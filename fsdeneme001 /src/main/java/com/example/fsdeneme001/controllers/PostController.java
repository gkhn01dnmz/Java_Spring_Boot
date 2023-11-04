package com.example.fsdeneme001.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;

import com.example.fsdeneme001.entities.Post;
import com.example.fsdeneme001.requests.PostCreateRequest;
import com.example.fsdeneme001.requests.PostUpdateRequest;
import com.example.fsdeneme001.services.PostService;

@RestController
@RequestMapping("/posts")    
public class PostController {
    
    PostService postService;


    public PostController(PostService postService) {
        this.postService = postService;
    }

    
    @GetMapping
    public Iterable<Post> getAllPosts(@RequestParam Optional<Long> userId) {
        return postService.getAllPosts(userId);
    }

    @GetMapping("/{postId}")
    public  Post getOnePost(@PathVariable Long postId) {
        return postService.getOnePostById(postId);
    }

    @PostMapping
    public Post createOnePost(@RequestBody PostCreateRequest newPostRequest) {
        return postService.createOnePost(newPostRequest);
    }

    @PutMapping("/{postId}")

    public Post updateOnePost(@RequestBody PostUpdateRequest newPostUpdate, @PathVariable Long postId) {
        return postService.updateOnePostById(newPostUpdate, postId);
    }


    @DeleteMapping("/{postId}")
    public void deleteOnePost(@PathVariable Long postId) {
        postService.deleteOnePostById(postId);
    }
    


}



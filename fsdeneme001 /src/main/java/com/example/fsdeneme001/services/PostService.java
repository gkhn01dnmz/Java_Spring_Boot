package com.example.fsdeneme001.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.fsdeneme001.entities.Post;
import com.example.fsdeneme001.entities.User;
import com.example.fsdeneme001.repos.PostRepository;
import com.example.fsdeneme001.requests.PostCreateRequest;
import com.example.fsdeneme001.requests.PostUpdateRequest;
@Service
public class PostService {


    PostRepository postRepository;
    UserService userService;
    public PostService(PostRepository postRepository,UserService userService) {
        this.postRepository = postRepository;
        this.userService = userService;
    }

    public Iterable<Post> getAllPosts(Optional<Long> userId) {
        if (userId.isPresent()){
            return postRepository.findByUserId(userId.get());
        }
        return postRepository.findAll();
    }

    public Post getOnePostById(Long postId) {
        return  postRepository.findById(postId).orElse(null);
    }

    public Post createOnePost(PostCreateRequest newPostRequest) {
        
        // burdaki getUserId data lombok sayesinde oluşturulmuş getter
        User user=userService.getOneUserById(newPostRequest.getUserId());
        if(user==null){
            return null;
        }
        //newPostRequest i post objesine çeviriyorum.
        Post toSave=new Post();
        toSave.setId(newPostRequest.getId());
        toSave.setText(newPostRequest.getText());
        toSave.setTitle(newPostRequest.getTitle());
        
        toSave.setUser(user);
        return postRepository.save(toSave);
    }

    public Post updateOnePostById(PostUpdateRequest newPostUpdate, Long postId) {
        Optional<Post> post=postRepository.findById(postId);
        if(post.isPresent()){
            Post postToUpdate=post.get();
            postToUpdate.setText(newPostUpdate.getText());
            postToUpdate.setTitle(newPostUpdate.getTitle());
            postRepository.save(postToUpdate);
            return  postToUpdate;
           
        }
        return null;
    }



    public void deleteOnePostById(Long postId) {
        postRepository.deleteById(postId);
    }
    
}

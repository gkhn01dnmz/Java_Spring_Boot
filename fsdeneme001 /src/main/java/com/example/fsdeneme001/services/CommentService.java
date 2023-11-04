package com.example.fsdeneme001.services;


import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.fsdeneme001.entities.Comment;
import com.example.fsdeneme001.entities.Post;
import com.example.fsdeneme001.entities.User;
import com.example.fsdeneme001.repos.CommentRepository;
import com.example.fsdeneme001.requests.CommentCreateRequest;
import com.example.fsdeneme001.requests.CommentUpdateRequest;



@Service
public class CommentService {


    CommentRepository commentRepository;
    UserService  userService;
    PostService postService;
    

    public CommentService(CommentRepository commentRepository,UserService userService,PostService postService) {
        this.commentRepository = commentRepository;
        this.userService = userService;
        this.postService = postService;
    }

    public Iterable<Comment> getAllCommentsWithParam(Optional<Long> userId, Optional<Long> postId) {
        if(userId.isPresent() && postId.isPresent()){
            return commentRepository.findByUserIdAndPostId(userId.get(), postId.get());
        }else if(userId.isPresent()){
            return commentRepository.findByUserId(userId.get());
        }else if(postId.isPresent()){
            return 
            commentRepository.findByPostId(postId.get());
        }else
            return commentRepository.findAll();
    }

    public Comment getOneCommentById(Long commentId) {
        return commentRepository.findById(commentId).orElse(null);
    }

    public Comment createOneComment(CommentCreateRequest newCommentrequest) {
        User user=userService.getOneUserById(newCommentrequest.getUserId());
        Post post=postService.getOnePostById(newCommentrequest.getPostId());
        if(user==null&& post==null){
            return null;
        }
        Comment toSave=new Comment();
        toSave.setId(newCommentrequest.getId());
        toSave.setText(newCommentrequest.getText());
        toSave.setUser(user);
        toSave.setPost(post);
        return commentRepository.save(toSave);
    }

    public Comment updateOneCommentById(Long commentId, CommentUpdateRequest updateCommentRequest) {
        Optional<Comment> comment=commentRepository.findById(commentId);
        if(comment.isPresent()){
            Comment toUpdate=comment.get();
            toUpdate.setText(updateCommentRequest.getText());
            return commentRepository.save(toUpdate);
        }else
            return null;
    }

    public void deleteOneCommentById(Long commentId) {
        commentRepository.deleteById(commentId);
    }


}

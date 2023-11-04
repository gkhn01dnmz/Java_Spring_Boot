package com.example.fsdeneme001.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.fsdeneme001.entities.Comment;
import com.example.fsdeneme001.entities.Like;
import com.example.fsdeneme001.entities.Post;
import com.example.fsdeneme001.entities.User;
import com.example.fsdeneme001.repos.LikeRepository;
import com.example.fsdeneme001.requests.LikeCreateRequest;
@Service
public class LikeService {
    LikeRepository likeRepository;
    UserService userService;
    PostService postService;
    CommentService commentService;
    public LikeService(LikeRepository likeRepository,UserService userService,PostService postService,CommentService commentService) {
        this.userService = userService;
        this.postService = postService;
        this.commentService = commentService;
        this.likeRepository = likeRepository;
    }

    public List<Like> getAllLikes(Optional<Long> userId, Optional<Long> postId, Optional<Long> commentId) {
        if(userId.isPresent() && postId.isPresent()&& commentId.isPresent()) {
            return likeRepository.findByUserIdAndPostIdAndCommentId(userId.get(), postId.get(), commentId.get());
        }else if (commentId.isPresent() && postId.isPresent()){
            return likeRepository.findByPostIdAndCommentId(postId.get(), commentId.get());
        }else if (commentId.isPresent()&&userId.isPresent()) {
            return likeRepository.findByUserIdAndCommentId(userId.get(), commentId.get());
        }else if (postId.isPresent()&&userId.isPresent()) {
            return likeRepository.findByUserIdAndPostId(userId.get(), postId.get());
        }else if (postId.isPresent()) {
            return likeRepository.findByPostId(postId.get());
        }else if (commentId.isPresent())
            return likeRepository.findByCommentId(commentId.get());
        else if (userId.isPresent()){
            return likeRepository.findByUserId(userId.get());
        }else
            return likeRepository.findAll();
    }

    public Like getOneLikeById(Long likeId) {
        return likeRepository.findById(likeId).orElse(null);
    }

    public Like createLike(LikeCreateRequest newLikeCreate) {
        User user= userService.getOneUserById(newLikeCreate.getUserId());
        Post post=postService.getOnePostById(newLikeCreate.getPostId());
        Comment comment=commentService.getOneCommentById(newLikeCreate.getCommentId());
        if(post==null&&comment==null&&user==null){
            return null;
        }
        Like toSave=new Like();
        toSave.setId(newLikeCreate.getId());
        toSave.setPost(post);
        toSave.setComment(comment);
        toSave.setUser(user);
        return likeRepository.save(toSave);
    }

    public void deleteLikeById(Long likeId) {
        likeRepository.deleteById(likeId);
    }
}

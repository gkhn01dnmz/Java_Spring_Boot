package com.example.fsdeneme001.controllers;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;
import java.util.List;


import com.example.fsdeneme001.entities.Like;
import com.example.fsdeneme001.requests.LikeCreateRequest;
import com.example.fsdeneme001.services.LikeService;
@RestController
@RequestMapping("/likes")
public class LikeController {
    LikeService likeService;

    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }

    @GetMapping
    public List<Like>getAllLikes(@RequestParam Optional<Long> userId, @RequestParam Optional<Long> postId,@RequestParam Optional<Long> commentId) {
        return likeService.getAllLikes(userId, postId, commentId);
    }

    @GetMapping("/{likeId}")
    public Like getOneComment(@PathVariable Long likeId){
        return likeService.getOneLikeById(likeId);
    }

    @PostMapping
    public Like createLike(@RequestBody LikeCreateRequest newLikeCreate){
        return likeService.createLike(newLikeCreate);
    }

    @DeleteMapping("/{likeId}")
    public void deleteLike(@PathVariable Long likeId){
        likeService.deleteLikeById(likeId);
    }
    
}

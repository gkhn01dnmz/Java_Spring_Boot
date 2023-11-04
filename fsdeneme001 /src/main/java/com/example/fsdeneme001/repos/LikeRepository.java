package com.example.fsdeneme001.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.fsdeneme001.entities.Like;

public interface LikeRepository extends JpaRepository<Like, Long>{

    List<Like> findByUserIdAndPostIdAndCommentId(Long userId, Long postId, Long commentId);

    List<Like> findByPostIdAndCommentId(Long postId, Long commentId);

    List<Like> findByUserIdAndCommentId(Long userId, Long commentId);

    List<Like> findByUserIdAndPostId(Long userId, Long postId);

    List<Like> findByPostId(Long postId);

    List<Like> findByCommentId(Long commentId);

    List<Like> findByUserId(Long userId);
    
}

package com.example.fsdeneme001.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.fsdeneme001.entities.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    Iterable<Comment> findByUserIdAndPostId(Long userId, Long postId);

    Iterable<Comment> findByUserId(Long userId);

    Iterable<Comment> findByPostId(Long postId);

}

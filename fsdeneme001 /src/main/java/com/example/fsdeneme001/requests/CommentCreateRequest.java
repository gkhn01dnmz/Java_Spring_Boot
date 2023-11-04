package com.example.fsdeneme001.requests;

import lombok.Data;

@Data
public class CommentCreateRequest {
    private Long id;
    private String text;
    private Long userId;
    private Long postId;
}

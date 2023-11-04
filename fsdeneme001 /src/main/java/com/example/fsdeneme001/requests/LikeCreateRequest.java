package com.example.fsdeneme001.requests;

import lombok.Data;

@Data
public class LikeCreateRequest {
    private Long id;
    private Long commentId;
    private Long userId;
    private Long postId;
}

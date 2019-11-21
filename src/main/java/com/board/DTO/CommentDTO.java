package com.board.DTO;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class CommentDTO {
    private int commentId;
    private String content;
    private int userId;
    private int postId;
    private Timestamp createdTime;
    private Timestamp updatedTime;
}

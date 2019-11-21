package com.board.DTO;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class PostDTO {
    private int postId;
    private String title;
    private String content;
    private int userId;
    private Timestamp createdTime;
    private Timestamp updatedTime;
}

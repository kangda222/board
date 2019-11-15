package com.board.DTO;

import lombok.Data;

import java.sql.Date;

@Data
public class PostDTO {
    private int postId;
    private String title;
    private String content;
    private Date createdTime;
    private Date updatedTime;
}
